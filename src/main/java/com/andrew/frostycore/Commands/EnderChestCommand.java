package com.andrew.frostycore.Commands;

import com.andrew.frostycore.Enums.StringEnum;
import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CommandManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class EnderChestCommand extends CommandManager {

    private Cache<UUID, Long> cooldown = CacheBuilder.newBuilder().expireAfterWrite(3, TimeUnit.SECONDS).build();

    private Main main;

    public EnderChestCommand(Main main) {
        super(
                "enderchest",
                new String[]{"ec"},
                "Opens a virtual furnace",
                " ",
                " ");
        this.main = main;

    }

    @Override
    public void execute(CommandSender sender, String[] args) {

        if (!(sender instanceof Player player)) {
            sender.sendMessage(StringEnum.PLAYER_ONLY_COMMAND.getValue());
            return;
        }

        if (!cooldown.asMap().containsKey(player.getUniqueId())) {
            cooldown.put(player.getUniqueId(), System.currentTimeMillis() + 3000);
            if (args.length == 0) {
                player.openInventory(player.getEnderChest());
                player.playSound(player.getLocation(), org.bukkit.Sound.BLOCK_ENDER_CHEST_OPEN, 1, 1);
                player.sendMessage(ChatColorUtil.colorize(StringEnum.FROSTYCORE_PREFIX.getValue() + "  &7Opening your enderchest..."));
                return;
            }

            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage(ChatColorUtil.colorize(StringEnum.FROSTYCORE_PREFIX.getValue() + " " + StringEnum.PLAYER_NOT_FOUND.getValue()));
                    return;
                }
                player.openInventory(target.getInventory());
                player.sendMessage(ChatColorUtil.colorize(StringEnum.FROSTYCORE_PREFIX.getValue() + " &7Opening " + target.getName() + "'s enderchest..."));
            }

            if (args.length != 0 && args.length != 1) {
                player.sendMessage(ChatColorUtil.colorize(StringEnum.FROSTYCORE_PREFIX.getValue() + " &cUsage: /enderchest <player>"));
            }
        } else {
            long distance = cooldown.asMap().get(player.getUniqueId()) - System.currentTimeMillis();
            player.sendMessage(ChatColor.RED + "You must wait " + TimeUnit.MILLISECONDS.toSeconds(distance) + " seconds to use this again.");
        }
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, String[] args) {

        if (args.length == 1) {
            List<String> names = new ArrayList<>();
            for (Player player : Bukkit.getOnlinePlayers()) {
                names.add(player.getName());
            }
            return StringUtil.copyPartialMatches(args[0], names, new ArrayList<>());

        }
        return new ArrayList<>();
    }
}
