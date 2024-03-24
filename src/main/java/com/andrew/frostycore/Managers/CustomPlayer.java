package com.andrew.frostycore.Managers;

import com.andrew.frostycore.Enums.RankEnum;
import com.andrew.frostycore.Main;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class CustomPlayer {
    private Main main;

    private UUID uuid;
    private String rank;
    private int coins;

    public CustomPlayer(Main main, UUID uuid) throws SQLException {
        this.main = main;

        this.uuid = uuid;

        PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("SELECT RANK, COINS FROM players WHERE UUID = ?; ");
        statement.setString(1, uuid.toString());
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            rank = rs.getString("RANK");
            coins = rs.getInt("COINS");
        } else {
            rank = RankEnum.MEMBER.name();
            coins = 0;
            PreparedStatement statement1 = main.getDatabase().getConnection().prepareStatement("INSERT INTO players (ID, UUID, RANK, COINS) VALUES (" +
                    "default," +
                    "'" + uuid + "'," +
                    "'" + rank + "'," +
                    coins + ");");
            statement1.executeUpdate();
        }
    }

    public void setRank(RankEnum rank) {
        try {
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE players SET RANK = '" + rank + "' WHERE UUID = '" + uuid + "';");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void setCoins(int coins) {
        this.coins = coins;
        try {
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE players SET COINS = " + coins + " WHERE UUID = '" + uuid + ";");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getRank() { return rank; }
    public int getCoins() { return coins; }
}
