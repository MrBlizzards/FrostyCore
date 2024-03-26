package com.andrew.frostycore.Managers;

import com.andrew.frostycore.Utils.ChatColorUtil;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private String name;

    private String display;

    private char rankRanking;

    private List<String> perms = new ArrayList<>();


    public Rank(String name, String display, char rankRanking) {
        this.name = name;
        this.display = display;
        this.rankRanking = rankRanking;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplay() {
        return ChatColorUtil.colorize(this.display);
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public char getRankRanking() {
        return this.rankRanking;
    }

    public void setRankRanking(char rankRanking) {
        this.rankRanking = rankRanking;
    }
}

