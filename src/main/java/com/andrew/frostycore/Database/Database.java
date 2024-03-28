package com.andrew.frostycore.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

    private final String HOST = "localhost";
    private final int PORT = 3306;
    private final String DATABASE = "frostycore";
    private final String USERNAME = "root";
    private final String PASSWORD = "";

    private Connection connection;

    public void connect() throws SQLException {

            connection = DriverManager.getConnection(
                    "jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE + "?useSSL=false",
                    USERNAME,
                    PASSWORD);

    }

    public boolean isConnected() { return connection != null; }

    public Connection getConnection() { return connection; }

    public void disconnect() {
          if (isConnected()) {
              try {
                  connection.close();
              } catch (SQLException e) {
                  e.printStackTrace();
              }
          }
    }

    public void initializeDatabase() throws SQLException {

        Statement statement = getConnection().createStatement();

        //Create the player_stats table
        String sql = "CREATE TABLE IF NOT EXISTS players (ID int primary key, UUID varchar(36), USERNAME varchar(20), RANK varchar(30), COINS int)";

        statement.execute(sql);

        statement.close();

    }

}
