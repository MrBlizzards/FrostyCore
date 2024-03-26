package com.andrew.frostycore.Commands.Server;

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

public class DeleteWarpCommand extends CommandManager {

    private Main main;

    public DeleteWarpCommand(Main main) {
        super(
                "delwarp",
                new String[]{"dw"},
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

        if (args.length != 1) {
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cUsage: /delwarp <name>"));
            return;
        }

        if (!warps.contains(args[0])) {
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cWarp not found."));
            return;
        }

        warps.set(args[0], null);
        main.getWarpManager().saveWarps();
        player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &aWarp " + args[0] + " has been deleted."));

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
