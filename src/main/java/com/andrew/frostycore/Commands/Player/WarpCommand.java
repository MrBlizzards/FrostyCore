package com.andrew.frostycore.Commands.Player;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

public class WarpCommand extends CommandManager {

    private Main main;

    public WarpCommand(Main main) {
        super(
                "warp",
                new String[]{"w"},
                "",
                "",
                "");
        this.main = main;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        YamlConfiguration warps = main.getWarpManager().getWarps();

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ServerMessage.getPlayerOnlyCommand());
            return;
        }

        if (args.length == 0) {
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cUsage: /warp <name>"));
            return;
        }

        if (warps.contains(args[0])) {
            player.teleport(main.getWarpManager().getWarp(args[0]));
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() +" &aTeleported to " + args[0]));
            return;
        }

        player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() +" &cWarp not found"));

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {

        if (args.length == 1) {
            List<String> warps = new ArrayList<>(main.getWarpManager().getWarps().getKeys(false));
            return StringUtil.copyPartialMatches(args[0], warps, new ArrayList<>());

        }
        return new ArrayList<>();
    }
}
