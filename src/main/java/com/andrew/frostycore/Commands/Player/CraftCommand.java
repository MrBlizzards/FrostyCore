package com.andrew.frostycore.Commands.Player;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CraftCommand extends CommandManager {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();

    public CraftCommand() {
        super(
                "craft",
                new String[]{"craft", "c"},
                "Opens a virtual crafting table.",
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
            player.sendMessage(ChatColorUtil.colorize(ServerMessage.getServerPrefix() + " &cUsage: /craft"));
            return;
        }

        if (!cooldown.asMap().containsKey(player.getUniqueId())) {
            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 3000);
            player.openWorkbench(null, true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', ServerMessage.getServerPrefix() + ChatColorUtil.colorize(" &aOpening a virtual crafting table...")));
        } else {
            long distance = cooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
            player.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " seconds to use this again.");
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {
        return null;
    }
}
