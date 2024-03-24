package com.andrew.frostycore.Commands;

import com.andrew.frostycore.Enums.StringEnum;
import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
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

    private Main main;

    public CraftCommand(Main main) {
        super(
                "craft",
                new String[]{"craft", "c"},
                "Opens a virtual crafting table.",
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

        if (args.length != 0) {
            player.sendMessage(ChatColorUtil.colorize(StringEnum.FROSTYCORE_PREFIX.getValue() + " &cUsage: /craft."));
            return;
        }

        if (!cooldown.asMap().containsKey(player.getUniqueId())) {
            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 3000);
            player.openWorkbench(null, true);
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', StringEnum.FROSTYCORE_PREFIX.getValue() + ChatColorUtil.colorize(" &7Opening a virtual crafting table...")));
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
