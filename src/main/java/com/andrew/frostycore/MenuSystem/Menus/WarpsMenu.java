package com.andrew.frostycore.MenuSystem.Menus;

import com.andrew.frostycore.MenuSystem.Menu;
import com.andrew.frostycore.MenuSystem.PlayerMenuUtility;
import com.andrew.frostycore.Utils.ChatColorUtil;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class WarpsMenu extends Menu {
    public WarpsMenu(PlayerMenuUtility playerMenuUtility) {
        super(playerMenuUtility);
    }

    @Override
    public String getMenuName() {
        return "Warps Menu";
    }

    @Override
    public int getSlots() {
        return 54;
    }

    @Override
    public void handleMenu(InventoryClickEvent e) {

        Player player = (Player) e.getWhoClicked();

switch (e.getCurrentItem().getType()) {
            case GRASS_BLOCK:
                player.performCommand("warp spawn");
                break;
            case DIAMOND_HOE:
                player.performCommand("warp farm");
                break;
            case ENCHANTING_TABLE:
                player.performCommand("warp enchant");
                break;
            case CHEST:
                player.performCommand("warp shop");
                break;
            case SPAWNER:
                player.performCommand("warp spawner");
                break;
            case BOOK:
                player.performCommand("warp job");
                break;
            case IRON_BOOTS:
                player.performCommand("warp wild");
                break;
            case NETHER_STAR:
                player.performCommand("warp event");
                break;
            case DIRT:
                player.performCommand("warp overworld");
                break;
            case NETHERRACK:
                player.performCommand("warp nether");
                break;
            case END_STONE:
                player.performCommand("warp end");
                break;
        }

    }

    @Override
    public void setMenuItems() {

        setFillerGlass();

        // General Warps
         ItemStack warpSpawn = makeItem(Material.GRASS_BLOCK, ChatColorUtil.colorize("&a&lWarp Spawn"), ChatColorUtil.colorize("&7Warp to spawn"));
         inventory.setItem(10, warpSpawn);

        ItemStack warpFarm = makeItem(Material.DIAMOND_HOE, ChatColorUtil.colorize("&2&lWarp Farms"), ChatColorUtil.colorize("&7Warp to player farms"));
        inventory.setItem(11, warpFarm);

        ItemStack warpEnchant = makeItem(Material.ENCHANTING_TABLE, ChatColorUtil.colorize("&d&lWarp Enchants"), ChatColorUtil.colorize("&7Warp to public enchantment table"));
        inventory.setItem(12, warpEnchant);

        ItemStack warpShop = makeItem(Material.CHEST, ChatColorUtil.colorize("&6&lWarp Shops"), ChatColorUtil.colorize("&7Warp to player shops"));
        inventory.setItem(13, warpShop);

        ItemStack warpSpawner = makeItem(Material.SPAWNER, ChatColorUtil.colorize("&5&lWarp Spawners"), ChatColorUtil.colorize("&7Warp to player spawners"));
        inventory.setItem(14, warpSpawner);

        ItemStack warpJob = makeItem(Material.BOOK, ChatColorUtil.colorize("&b&lWarp Jobs"), ChatColorUtil.colorize("&7Warp to public jobs"));
        inventory.setItem(15, warpJob);

        ItemStack warpWild = makeItem(Material.IRON_BOOTS, ChatColorUtil.colorize("&e&lWarp Wild"), ChatColorUtil.colorize("&7Warp to the wild"));
        inventory.setItem(16, warpWild);

        // Special Warps
        ItemStack warpOverworld = makeItem(Material.DIRT, ChatColorUtil.colorize("&a&lWarp Overworld"), ChatColorUtil.colorize("&7Warp to the overwold"));
        inventory.setItem(30, warpOverworld);

        ItemStack warpNether = makeItem(Material.NETHERRACK, ChatColorUtil.colorize("&c&lWarp Nether"), ChatColorUtil.colorize("&7Warp to the nether spawn"));
        inventory.setItem(31, warpNether);

        ItemStack warpEnd = makeItem(Material.END_STONE, ChatColorUtil.colorize("&e&lWarp End"), ChatColorUtil.colorize("&7Warp to the end spawn"));
        inventory.setItem(32, warpEnd);

        ItemStack warpEvent = makeItem(Material.NETHER_STAR, ChatColorUtil.colorize("&6&lWarp Event World"), ChatColorUtil.colorize("&7Warp to the event world!"));
        inventory.setItem(40, warpEvent);
    }
}
