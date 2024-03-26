package com.andrew.frostycore.Commands.Server;

import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class DayCommand extends CommandManager {

    public DayCommand() {
        super(
                "day",
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
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cUsage: /day"));
            return;

        }
        player.getWorld().setTime(6000);
        player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &aTime set to day"));
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
