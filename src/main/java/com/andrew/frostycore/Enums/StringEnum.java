package com.andrew.frostycore.Enums;

import com.andrew.frostycore.Utils.ChatColorUtil;

import java.util.Arrays;
import java.util.List;

public enum StringEnum {

    FROSTYCORE_PREFIX(ChatColorUtil.colorize("&8[&3&lFrosty&b&lCore&8]")),
    PLAYER_NOT_FOUND(ChatColorUtil.colorize(" &cPlayer not found!")),
    PLAYER_ONLY_COMMAND(ChatColorUtil.colorize("Only a player may execute this command.")),
    OP_ONLY_COMMAND(ChatColorUtil.colorize("&cYou must be OP to use this command!"));

    private String value;

    StringEnum(String value) {
        this.value = value;
    }

    List<StringEnum> getAllStringEnum() { return Arrays.asList(StringEnum.values()); }

    public String getValue() { return value; }

}

