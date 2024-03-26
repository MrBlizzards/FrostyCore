package com.andrew.frostycore.Commands.Server;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.Location;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.List;

public class SetWarpCommand extends CommandManager {

    private Main main;

    public SetWarpCommand(Main main) {
        super(
                "setwarp",
                new String[]{"sw"},
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
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " Usage: /setwarp <name>"));
            return;
        }

        if (warps.contains(args[0])) {
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cWarp already exists"));
            return;
        }

        Location loc = player.getLocation();

        main.getWarpManager().setWarp(args[0], loc);
        main.getWarpManager().saveWarps();

        player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &aWarp " + args[0] + " has been set"));

    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
