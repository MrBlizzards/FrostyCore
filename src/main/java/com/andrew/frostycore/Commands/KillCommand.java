package com.andrew.frostycore.Commands;

import com.andrew.frostycore.Enums.StringEnum;
import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.MenuSystem.Menus.KillPlayerMenu;
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
            sender.sendMessage(StringEnum.PLAYER_ONLY_COMMAND.getValue());
            return;
        }

        new KillPlayerMenu(Main.getPlayerMenuUtility(player)).open();
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}


