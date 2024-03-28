package com.andrew.frostycore.Listeners;

import com.andrew.frostycore.Database.Database;
import com.andrew.frostycore.Main;
import com.andrew.frostycore.Managers.Rank;
import com.andrew.frostycore.Managers.RankManager;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.andrew.frostycore.Utils.ServerMessage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.scoreboard.*;

import java.sql.SQLException;

public class ScoreBoardListener implements Listener {

    private Main main;
    private Database database;

    public ScoreBoardListener(Main main, Database database) {
        this.database = database;
        this.main = main;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) throws SQLException {

        createBoard(e.getPlayer());
    }

    public void createBoard(Player player) throws SQLException {
        // CREATE THE SCOREBOARD
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard board = manager.getNewScoreboard();

        // CREATE THE SIDEBAR
        createSidebar(board, player);

        // CREATE THE PLAYER LIST SCOREBOARD
        createPlayerList(board, player);

        // SETS THE SCOREBOARD
        player.setScoreboard(board);
    }

    public void createSidebar(Scoreboard board, Player player) throws SQLException {
        Objective obj = board.registerNewObjective("Sidebar-Rank", "dummy", ChatColorUtil.colorize(ServerMessage.getServerPrefix()));
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        // RIGHT UNDER THE TITLE
        Score line2 = obj.getScore(ChatColorUtil.colorize(("&7&l-----------------")));
        line2.setScore(7);

        // SPACE #2
        Score space2 = obj.getScore("   ");
        space2.setScore(6);

        // PLAYER NAME
        Score playerName = obj.getScore(ChatColorUtil.colorize("&7&lName: &7" + player.getName()));
        playerName.setScore(5);

        // RANK TEAM SYSTEM
        Team team1 = board.registerNewTeam("team1");
        String teamKey = ChatColor.GOLD.toString();

        team1.addEntry(teamKey);
        team1.setPrefix(ChatColorUtil.colorize("&7&lRank: "));

        String playerRank = database.findPlayerStatsByUUID(player.getUniqueId()).getRank();
        Rank rank = RankManager.getRankName(playerRank);
        if (rank != null) {
            team1.setSuffix(rank.getPrefix());
        }

        player.setPlayerListName(team1.getPrefix() + " " + ChatColor.GRAY + player.getName());

        obj.getScore(teamKey).setScore(4);

        // SPACE #1
        Score space1 = obj.getScore(" ");
        space1.setScore(3);

        // RIGHT ABOVE THE WEBSITE
        Score line1 = obj.getScore(ChatColorUtil.colorize(("&7&l----------------- ")));
        line1.setScore(2);

        // WEBSITE AT THE BOTTOM
        Score website = obj.getScore(ChatColorUtil.colorize(("&7www.frostednetwork.com")));
        website.setScore(1);
    }

    private void createPlayerList(Scoreboard board, Player player) throws SQLException {
        Objective playerListObj = board.registerNewObjective("playerlist", "dummy");
        playerListObj.setDisplaySlot(DisplaySlot.PLAYER_LIST);

        Team team2 = board.registerNewTeam("team2");

        String playerRank = database.findPlayerStatsByUUID(player.getUniqueId()).getRank();
        Rank rank = RankManager.getRankName(playerRank);
        if (rank != null) {
            team2.setPrefix(rank.getPrefix());
        }

        player.setPlayerListName(team2.getPrefix() + " " + ChatColor.GRAY + player.getName());

    }
}