package com.andrew.frostycore.Managers;

import com.andrew.frostycore.Database.Database;
import com.andrew.frostycore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.function.BiConsumer;

public class NameTagManager {

    private Database database;

    public NameTagManager(Database database) {
        this.database = database;
    }

    public void setNameTags(Player player) throws SQLException {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        for (Player target : Bukkit.getOnlinePlayers()) {
            Team team = player.getScoreboard().registerNewTeam(target.getName());
            PlayerStats playerStats = database.findPlayerStatsByUUID(target.getUniqueId());
            team.setPrefix(playerStats.getRank());
            team.addEntry(target.getName());
        }
    }

    public void updateTag(Player player, BiConsumer<Team, String> action) {
        for (Player target : Bukkit.getOnlinePlayers()) {
            Team team = target.getScoreboard().getTeam(player.getName());
            if (team != null) {
                action.accept(team, player.getName());
            }
        }
    }

    public void removeTag(Player player) {
        updateTag(player, Team::removeEntry);
    }

    public void newTag(Player player) {
        updateTag(player, Team::addEntry);
    }

    public void updateScoreBoard(Player player) {
        Scoreboard board = player.getScoreboard();
        RankManager rankManager = new RankManager();
        Team team1 = board.getTeam("team1");
        Team team2 = board.getTeam("team2");

        PlayerStats playerStats = database.findPlayerStatsByUUID(player.getUniqueId());
        Rank playerRank = rankManager.getPrefix(playerStats.getRank());

        if (team1 != null) {
            team1.setSuffix(playerRank.getPrefix());
        }
        if (team2 != null) {
            team2.setPrefix(playerRank.getPrefix());
            player.setPlayerListName(team2.getPrefix() + " " + ChatColor.GRAY + player.getName());
        }
    }

    public void updateNameTag(Player player) {
        removeTag(player);
        newTag(player);
    }
}