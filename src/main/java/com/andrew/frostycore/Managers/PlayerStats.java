package com.andrew.frostycore.Managers;

import com.andrew.frostycore.Main;
import com.andrew.frostycore.Utils.ChatColorUtil;
import com.google.common.collect.Maps;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.UUID;

public class CustomPlayer {

    private Main main;
    private final UUID uuid;
    private String username;
    private String rank;
    private int coins;

    public CustomPlayer(Main main, UUID uuid) throws SQLException {
        this.main = main;
        this.uuid = uuid;
        this.username = Bukkit.getOfflinePlayer(uuid).getName();
        initializePlayer();
    }

    public void setRank(RankEnum rank) {
        this.rank = rank.rankName;
        updatePlayerRank();
    }

    public void setCoins(int coins) {
        this.coins = coins;
        updatePlayerCoins();
    }

    public RankEnum getRank() {
        RankEnum rankEnum = null;
        try {
            rankEnum = RankEnum.valueOf(rank.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Rank not found in RankEnum: " + rank);
        }
        if (rankEnum == null) {
            System.out.println("Rank is null for UUID: " + uuid);
        }
        return rankEnum;
    }

    public int getCoins() {
        return coins;
    }

    public String getName() {
        return Bukkit.getOfflinePlayer(uuid).getName();
    }

    public enum RankEnum {

        MEMBER(ChatColorUtil.colorize("&8[&7&lMember&8]"), "Member", 'A'),
        KNIGHT(ChatColorUtil.colorize("&8[&8&lKnight&8]"), "Knight", 'B'),
        HERO(ChatColorUtil.colorize("&8[&3&lHero&8]"), "Hero", 'C'),
        ELITE(ChatColorUtil.colorize("&8[&e&lElite&8]"), "Elite", 'D'),
        ULTRA(ChatColorUtil.colorize("&8[&d&lUltra&8]"), "Ultra", 'E'),
        LEGEND(ChatColorUtil.colorize("&8[&b&lLegend&8]"), "Legend", 'F'),
        TITAN(ChatColorUtil.colorize("&8[&6&lTitan&8]"), "Titan", 'G'),
        WIZARD(ChatColorUtil.colorize("&8[&3&lWizard&8]"), "Wizard", 'H'),

        // STAFF RANKS
        HELPER(ChatColorUtil.colorize("&8[&e&lHelper&8]"), "Helper", 'I'),
        MOD(ChatColorUtil.colorize("&8[&d&lModerator&8]"), "Mod", 'J'),
        ADMIN(ChatColorUtil.colorize("&8[&c&lAdministrator&8]"), "Admin", 'K'),
        OWNER(ChatColorUtil.colorize("&8[&4&lOwner&8]"), "Owner", 'L');

        private String display;
        private String rankName;
        private char rankRanking;

        RankEnum(String display, String rankName, char rankRanking) {
            this.display = display;
            this.rankName = rankName;
            this.rankRanking = rankRanking;
        }

        public String getDisplay() {
            return display;
        }

        public void setDisplay(String display) {
            this.display = display;
        }

        public String getRankName() {
            return rankName;
        }

        public void setRankName(String rankName) {
            this.rankName = rankName;
        }

        public char getRankRanking() {
            return rankRanking;
        }

        public void setRankRanking(char rankRanking) {
            this.rankRanking = rankRanking;
        }
    }

    public void initializePlayer() throws SQLException {

        PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("SELECT USERNAME, RANK, COINS FROM players WHERE UUID = ?; ");
        statement.setString(1, uuid.toString());
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            rank = rs.getString("RANK");
            username = rs.getString("USERNAME");
            coins = rs.getInt("COINS");
        } else {
            rank = RankEnum.MEMBER.name();
            coins = 0;
            username = getName();
            PreparedStatement statement1 = main.getDatabase().getConnection().prepareStatement("INSERT INTO players (ID, UUID, USERNAME, RANK, COINS) VALUES (" +
                    "default," +
                    "'" + uuid + "'," +
                    "'" + username + "'," +
                    "'" + rank + "'," +
                    coins + ");");
            statement1.executeUpdate();
            statement1.close();
        }
    }

    private void updatePlayerRank() {
        String sql = "UPDATE players SET RANK = ? WHERE UUID = ?";
        try (PreparedStatement statement = main.getDatabase().getConnection().prepareStatement(sql)) {
            statement.setString(1, rank);
            statement.setString(2, uuid.toString());
            statement.executeUpdate();

            Player player = Bukkit.getPlayer(uuid);
            if (player != null) {
                main.getNameTagManager().updateNameTag(player);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void updatePlayerCoins() {
        try {
            PreparedStatement statement = main.getDatabase().getConnection().prepareStatement("UPDATE players SET COINS = " + coins + " WHERE UUID = '" + uuid + ";");
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
