package com.andrew.frostycore.Utils;

public class ServerMessage {

    private static String ServerPrefix = "&8[&3&lFrosty&b&lCore&8]";
    private static String PlayerNotFound = " &cPlayer not found!";
    private static String PlayerOnlyCommand = "Only a player may execute this command.";
    private static String OpOnlyCommmand = "&cYou must be OP to use this command!";

    public static String getServerPrefix() {
        return ServerPrefix;
    }

    public static String getPlayerNotFound() {
        return PlayerNotFound;
    }

    public static String getPlayerOnlyCommand() {
        return PlayerOnlyCommand;
    }

    public static String getOpOnlyCommmand() {
        return OpOnlyCommmand;
    }
}
