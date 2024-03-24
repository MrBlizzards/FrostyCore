package com.andrew.frostycore;

import com.andrew.frostycore.Commands.*;
import com.andrew.frostycore.Database.Database;
import com.andrew.frostycore.Listeners.ConnectionListener;
import com.andrew.frostycore.Listeners.MenuListener;
import com.andrew.frostycore.Managers.PlayerManager;
import com.andrew.frostycore.MenuSystem.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    public static Main plugin;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private Database database;
    private PlayerManager playerManager;

    @Override
    public void onEnable() {

        plugin = this;

        database = new Database();
        try {
            database.connect();
        } catch (Exception e) {
            e.printStackTrace();
        }

        playerManager = new PlayerManager();

        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {

        database.disconnect();
    }

    // RETURNS DATABASE
    public Database getDatabase() { return database; }

    // RETURNS PLAYER MANAGER
    public PlayerManager getPlayerManager() { return playerManager; }

    // RETURNS NAME TAG MANAGER

    // REGISTERS LISTENERS
    private void registerListeners() {
        registerListeners(new ConnectionListener(this));
        registerListeners(new MenuListener());
    }

    // REGISTERS LISTENERS
    private void registerListeners(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    // REGISTERS COMMANDS
    private void registerCommands() {
        new CraftCommand(this);
        new EnderChestCommand(this);
        new GamemodeAdventure(this);
        new GamemodeCreative(this);
        new GamemodeSpectator(this);
        new GamemodeSurvival(this);
        new KillCommand(this);
        new RankCommand(this);
    }

    public static PlayerMenuUtility getPlayerMenuUtility(Player p) {
        PlayerMenuUtility playerMenuUtility;
        if (!(playerMenuUtilityMap.containsKey(p))) {

            playerMenuUtility = new PlayerMenuUtility(p);
            playerMenuUtilityMap.put(p, playerMenuUtility);

            return playerMenuUtility;
        } else {
            return playerMenuUtilityMap.get(p);
        }
    }

    public static Main getPlugin() {
        return plugin;
    }
}

