package com.andrew.frostycore.Commands.Server;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.MenuSystem.Menus.KillPlayerMenu;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

//

public class KillCommand extends CommandManager {

    private Main main;

    public KillCommand(Main main) {
        super(
                "kill",
                new String[]{"k"},
                "",
                "",
                "");
        this.main = main;
    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ServerMessage.getPlayerOnlyCommand());
            return;
        }

        new KillPlayerMenu(Main.getPlayerMenuUtility(player)).open();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}


