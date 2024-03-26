package com.andrew.frostycore.Commands.Player;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;

public class WarpsCommand extends CommandManager {

    private Main main;

    public WarpsCommand(Main main) {
        super(
                "warps",
                new String[]{" "},
                "",
                "",
                "");
        this.main = main;
    }
    //Warps warps = new Warps();
    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(ServerMessage.getPlayerOnlyCommand());
            return;
        }
        //player.openInventory(warps.getInventory());
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}

