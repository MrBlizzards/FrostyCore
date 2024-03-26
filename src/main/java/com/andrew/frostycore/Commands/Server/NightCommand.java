package com.andrew.frostycore.Commands.Server;

import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class NightCommand extends CommandManager {

    public NightCommand() {
        super(
                "night",
                new String[]{" "},
                "",
                "",
                "");
    }


    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ServerMessage.getPlayerOnlyCommand());
            return;
        }

        if (args.length != 0) {
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cUsage: /night"));
            return;

        }
        player.getWorld().setTime(18000);
        player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &aTime set to night"));
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
