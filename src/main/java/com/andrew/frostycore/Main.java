package com.andrew.frostycore;

import com.andrew.frostycore.Commands.Player.CraftCommand;
import com.andrew.frostycore.Commands.Player.WarpCommand;
import com.andrew.frostycore.Commands.Player.WarpsCommand;
import com.andrew.frostycore.Commands.Server.*;
import com.andrew.frostycore.Commands.Staff.*;
import com.andrew.frostycore.Database.Database;
import com.andrew.frostycore.Listeners.ConnectionListener;
import com.andrew.frostycore.Listeners.MenuListener;
import com.andrew.frostycore.Listeners.ScoreBoardListener;
import com.andrew.frostycore.Managers.NameTagManager;
import com.andrew.frostycore.Managers.PlayerManager;
import com.andrew.frostycore.Managers.WarpManager;
import com.andrew.frostycore.MenuSystem.PlayerMenuUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public final class Main extends JavaPlugin {

    public static Main plugin;
    private static final HashMap<Player, PlayerMenuUtility> playerMenuUtilityMap = new HashMap<>();
    private Database database;
    private PlayerManager playerManager;
    private NameTagManager nameTagManager;
    private WarpManager warpManager;

    @Override
    public void onEnable() {

        plugin = this;

        database = new Database();
        try {
            database.connect();
        } catch (Exception e) {
            System.out.println(ChatColor.RED + "ERROR: Could not connect to the database.");
        }

        playerManager = new PlayerManager();
        nameTagManager = new NameTagManager(this);
        warpManager = new WarpManager(this);

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
    public NameTagManager getNameTagManager() { return nameTagManager; }
    public WarpManager getWarpManager() { return warpManager; }

    // RETURNS NAME TAG MANAGER

    // REGISTERS LISTENERS
    private void registerListeners() {
        registerListeners(new ConnectionListener(this));
        registerListeners(new MenuListener());
        registerListeners(new ScoreBoardListener(this));
    }

    // REGISTERS LISTENERS
    private void registerListeners(Listener listener) {
        Bukkit.getPluginManager().registerEvents(listener, this);
    }

    // REGISTERS COMMANDS
    private void registerCommands() {

        // PLAYER COMMANDS
        new CraftCommand(this);
        new WarpCommand(this);
        new WarpsCommand(this);

        // SERVER COMMANDS
        new DayCommand();
        new DeleteWarpCommand(this);
        new DuskCommand();
        new EnderChestCommand(this);
        new GamemodeAdventure(this);
        new GamemodeCreative(this);
        new GamemodeSpectator(this);
        new GamemodeSurvival(this);
        new KillCommand(this);
        new MorningCommand();
        new NightCommand();
        new RankCommand(this);
        new SetWarpCommand(this);

        // STAFF COMMANDS
        new BanCommand(); // Need todo
        new FreezeCommand(); // Need todo
        new InvSeeCommand(); // Need todo
        new KickCommand(); // Need todo
        new MuteCommand(); // Need todo
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

