package com.andrew.frostycore.Commands.Server;

import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class DuskCommand extends CommandManager {

    public DuskCommand() {
        super(
                "dusk",
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
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cUsage: /dusk"));
            return;

        }
        player.getWorld().setTime(12000);
        player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &aTime set to dusk"));
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
