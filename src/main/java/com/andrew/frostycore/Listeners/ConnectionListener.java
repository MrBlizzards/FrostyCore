package com.andrew.frostycore.Listeners;

import com.andrew.frostycore.Enums.RankEnum;
import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.CustomPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.sql.SQLException;

public class ConnectionListener implements Listener {

    private Main main;

    public ConnectionListener(Main main) { this.main = main; }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        Player player = e.getPlayer();

        if (!player.hasPlayedBefore()) {
            try {
                CustomPlayer playerData = new CustomPlayer(main, player.getUniqueId());
                main.getPlayerManager().addCustomPlayer(player.getUniqueId(), playerData);
                main.getPlayerManager().getCustomPlayer(player.getUniqueId()).setRank(RankEnum.MEMBER);
            } catch (SQLException ex) {
                player.kickPlayer("Your data could not be loaded!");
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {

    main.getPlayerManager().removeCustomPlayer(e.getPlayer().getUniqueId());


    }
}
