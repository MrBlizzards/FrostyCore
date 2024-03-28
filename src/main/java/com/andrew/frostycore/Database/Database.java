package com.andrew.frostycore.Database;

import com.andrew.frostycore.Managers.PlayerStats;

import java.sql.*;
import java.util.UUID;
import java.sql.Statement;

public class Database {

    private Connection connection;

    public Connection getConnection() throws SQLException {

        if(connection != null){
            return connection;
        }

        String url = "jdbc:mysql://localhost/frostycore";
        String user = "root";
        String password = "";

        Connection connection = DriverManager.getConnection(url, user, password);

        this.connection = connection;

        System.out.println("Connected to database.");

        return connection;
    }

    public void initializeDatabase() {

        try {
            Statement statement = getConnection().createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS players (ID int primary key, USERNAME varchar(20), UUID varchar(36), RANK varchar(20), DEATHS int, KILLS int, LAST_LOGIN DATE, LAST_LOGOUT DATE)";
            statement.execute(sql);

            sql = "CREATE TABLE IF NOT EXISTS max_player_id (MAX_ID int)";
            statement.execute(sql);

            ResultSet resultSet = statement.executeQuery("SELECT MAX_ID FROM max_player_id");
            if (!resultSet.next()) {
                statement.executeUpdate("INSERT INTO max_player_id (MAX_ID) VALUES (0)");
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Could not initialize database.");
        }
    }

    public PlayerStats findPlayerStatsByUUID(UUID uuid)  {

        try {
            PreparedStatement statement = getConnection().prepareStatement("SELECT * FROM players WHERE UUID = ?");
            statement.setString(1, uuid.toString());

            ResultSet resultSet = statement.executeQuery();

            PlayerStats playerStats;

            if (resultSet.next()) {

                playerStats = new PlayerStats(resultSet.getString("USERNAME"), resultSet.getString("UUID"), resultSet.getString("RANK"), resultSet.getInt("DEATHS"), resultSet.getInt("KILLS"), resultSet.getDate("LAST_LOGIN"), resultSet.getDate("LAST_LOGOUT"));

                statement.close();

                return playerStats;
            }

            statement.close();

        } catch (SQLException e) {
            System.out.println("Could not find player stats by UUID.");
        }
        return null;
    }

    public int getNextPlayerId() throws SQLException {
        PreparedStatement statement = getConnection().prepareStatement("SELECT MAX_ID FROM max_player_id");
        ResultSet resultSet = statement.executeQuery();

        int nextId = 1;
        if (resultSet.next()) {
            nextId = resultSet.getInt("MAX_ID") + 1;
        }

        PreparedStatement updateStatement = getConnection().prepareStatement("UPDATE max_player_id SET MAX_ID = ?");
        updateStatement.setInt(1, nextId);
        updateStatement.executeUpdate();

        statement.close();
        updateStatement.close();

        return nextId;
    }

    public void createPlayerStats(PlayerStats playerStats) {

        try {
            PreparedStatement statement = getConnection()
                    .prepareStatement("INSERT INTO players(ID, USERNAME, UUID, RANK, DEATHS, KILLS, LAST_LOGIN, LAST_LOGOUT) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            statement.setInt(1, getNextPlayerId());
            statement.setString(2, playerStats.getPlayerUsername());
            statement.setString(3, playerStats.getPlayerUUID());
            statement.setString(4, playerStats.getRank());
            statement.setInt(5, playerStats.getDeaths());
            statement.setInt(6, playerStats.getKills());
            statement.setDate(7, new Date(playerStats.getLastLogin().getTime()));
            statement.setDate(8, new Date(playerStats.getLastLogout().getTime()));

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Could not create player stats.");
        }
    }

    public void updatePlayerStats(PlayerStats playerStats) {

        try {
            PreparedStatement statement = getConnection().prepareStatement("UPDATE players SET RANK = ?, DEATHS = ?, KILLS = ?, LAST_LOGIN = ?, LAST_LOGOUT = ? WHERE UUID = ?");
            statement.setString(1, playerStats.getRank());
            statement.setInt(2, playerStats.getDeaths());
            statement.setInt(3, playerStats.getKills());
            statement.setDate(4, new Date(playerStats.getLastLogin().getTime()));
            statement.setDate(5, new Date(playerStats.getLastLogout().getTime()));
            statement.setString(6, playerStats.getPlayerUUID());

            statement.executeUpdate();

            statement.close();

        } catch (SQLException e) {
            System.out.println("Could not update player stats.");
        }
    }

    public void deletePlayerStats(PlayerStats playerStats) {

        try {
            PreparedStatement statement = getConnection().prepareStatement("DELETE FROM players WHERE UIID = ?");
            statement.setString(1, playerStats.getPlayerUUID());
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {

    public void initializeDatabase() throws SQLException {

        Statement statement = getConnection().createStatement();

        //Create the player_stats table
        String sql = "CREATE TABLE IF NOT EXISTS players (ID int primary key, UUID varchar(36), USERNAME varchar(20), RANK varchar(30), COINS int)";

        statement.execute(sql);

        statement.close();

    }

            System.out.println("Could not delete player stats.");
        }
    }
}