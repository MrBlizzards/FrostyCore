package com.andrew.frostycore.Managers;

import com.andrew.frostycore.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.util.UUID;
import java.util.function.BiConsumer;

public class NameTagManager {

    private Main main;

    public NameTagManager(Main main) {
        this.main = main;
    }

    public void setNameTags(Player player) {
        player.setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());

        for (Player target : Bukkit.getOnlinePlayers()) {
            Team team = player.getScoreboard().registerNewTeam(target.getName());
            CustomPlayer.RankEnum rank = main.getPlayerManager().getCustomPlayer(target.getUniqueId()).getRank();
            team.setPrefix(rank.getDisplay());
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
        Team team1 = board.getTeam("team1");
        Team team2 = board.getTeam("team2");

        CustomPlayer.RankEnum rank = main.getPlayerManager().getCustomPlayer(player.getUniqueId()).getRank();
        String display = rank.getDisplay();

        if (team1 != null) {
            team1.setSuffix(display);
        }
        if (team2 != null) {
            team2.setPrefix(display);
            player.setPlayerListName(team2.getPrefix() + " " + ChatColor.GRAY + player.getName());
        }
    }

    public void updateNameTag(Player player) {
        removeTag(player);
        newTag(player);
    }
}