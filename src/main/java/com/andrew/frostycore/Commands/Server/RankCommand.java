package com.andrew.frostycore.Commands.Server;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Managers.CustomPlayer;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RankCommand extends CommandManager {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.SECONDS).build();

    private HashMap<UUID, CustomPlayer> customPlayers = new HashMap<>();

    private Main main;

    public RankCommand(Main main) {
        super(
                "rank",
                new String[]{},
                "",
                "",
                "");
        this.main = main;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        // Rank <player> <rank <type>

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ServerMessage.getPlayerOnlyCommand());
            return;
        }

        // Checks to see if the player is op or not.
        if (!player.isOp()) {
            sender.sendMessage(ChatColorUtil.colorize(ServerMessage.getOpOnlyCommmand()));
            return;
        }

        // Checks the argument length to see if it is 2.
        if (args.length != 2) {
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cInvaild usage! Please use /rank <player> <rank>."));
            return;
        }

        Player targetPlayer = Bukkit.getPlayer(args[0]);
        if (targetPlayer == null) {
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cThis user has never joined the server before!"));
            return;
        }

        CustomPlayer customPlayer = main.getPlayerManager().getCustomPlayer(targetPlayer.getUniqueId());
        if (customPlayer != null) {

            for (CustomPlayer.RankEnum rank : CustomPlayer.RankEnum.values()) {
                if (rank.getRankName() != null && rank.getRankName().equalsIgnoreCase(args[1])) {
                    main.getPlayerManager().getCustomPlayer(targetPlayer.getUniqueId()).setRank(rank);
                    main.getNameTagManager().updateScoreBoard(targetPlayer);

                    if (player == targetPlayer) {
                        player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &aYou have changed your rank to " + rank.getDisplay()));
                        return;
                    }

                    targetPlayer.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &a" + player.getName() + " &ahas changed your rank to " + rank.getDisplay()));
                    player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &aYou changed " + customPlayer.getName() + "&a's rank to " + rank.getDisplay() + "&a."));
                    return;

                }
            }
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {

        if (args.length == 1) {
            List<String> names = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                names.add(player.getName());
            }
            return StringUtil.copyPartialMatches(args[0], names, new ArrayList<>());
        } else if (args.length == 2) {
            List<String> ranks = new ArrayList<>();
            for (CustomPlayer.RankEnum rank : CustomPlayer.RankEnum.values()) {
                ranks.add(rank.getRankName());
            }
            return StringUtil.copyPartialMatches(args[1], ranks, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}