package com.andrew.frostycore.Listeners;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CustomPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;

public class ConnectionListener implements Listener {

    private Main main;

    public ConnectionListener(Main main) { this.main = main; }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        try {
            CustomPlayer playerData = new CustomPlayer(main, player.getUniqueId());
            main.getPlayerManager().addCustomPlayer(player.getUniqueId(), playerData);

            if (!player.hasPlayedBefore()) {
                playerData.initializePlayer(); // Initialize the player
            }

            main.getNameTagManager().setNameTags(player);
            main.getNameTagManager().updateNameTag(player);

        } catch (SQLException ex) {
            player.kickPlayer("Your data could not be loaded!");
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

        Player player = e.getPlayer();

        main.getPlayerManager().removeCustomPlayer(e.getPlayer().getUniqueId());

        main.getNameTagManager().removeTag(player);


    }
}
