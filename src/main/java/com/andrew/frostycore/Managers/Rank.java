package com.andrew.frostycore.Managers;

import com.andrew.frostycore.Utils.ChatColorUtil;

import java.util.ArrayList;
import java.util.List;

public class Rank {

    private int rankId;
    private boolean staff;
    private String prefix;
    private String rankName;
    private String rankPrefix;

    public Rank(int rankId, String rankName, boolean staff){
        this.rankId = rankId;
        this.rankName = rankName;
        this.staff = staff;
    }


    public boolean isStaff() {
        return staff;
    }

    public void setStaff(boolean staff) {
        this.staff = staff;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public int getRankId() {
        return rankId;
    }

    public void setRankId(int rankId) {
        this.rankId = rankId;
    }

    public String getRankName(){
        return rankName;
    }

    public void setRankName(String rankName){
        this.rankName = rankName;
    }

    public String getRankPrefix(){
        return rankPrefix;
    }

    public void setRankPrefix(String rankPrefix){
        this.rankPrefix = rankPrefix;
    }
}

