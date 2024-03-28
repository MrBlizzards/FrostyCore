package com.andrew.frostycore.Commands.Server;

import com.andrew.frostycore.Database.Database;
import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Managers.PlayerStats;
import com.andrew.frostycore.Managers.RankManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class RankCommand extends CommandManager {

    private Main main;
    private Database database;

    public RankCommand(Main main, Database database) {
        super(
                "rank",
                new String[]{},
                "",
                "",
                "");
        this.main = main;
        this.database = database;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        // Rank <player> set <rank>

        if (!(sender instanceof Player player)) {
            sender.sendMessage("Hi");
            return;
        }

        // Checks to see if the player is op or not.
        if (!player.isOp()) {
            sender.sendMessage(ChatColorUtil.colorize("Test"));
            return;
        }

        for (Player targetPlayer : Bukkit.getOnlinePlayers()) {
            if (targetPlayer.getName().equalsIgnoreCase(args[0])) {
                RankManager rankManager = new RankManager();
                for (String rank : RankManager.ranks.keySet()) {
                    if (args[1].equalsIgnoreCase(rank)) {
                            PlayerStats playerStats = database.findPlayerStatsByUUID(targetPlayer.getUniqueId());
                            playerStats.setRank(rank);
                            database.updatePlayerStats(playerStats);
                            main.getNameTagManager().updateScoreBoard(targetPlayer);
                        }
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
            RankManager rankManager = new RankManager();
            for (String rank : RankManager.ranks.keySet()) {
                ranks.add(rank);
            }
            return StringUtil.copyPartialMatches(args[1], ranks, new ArrayList<>());
        }
        return new ArrayList<>();
    }
}
