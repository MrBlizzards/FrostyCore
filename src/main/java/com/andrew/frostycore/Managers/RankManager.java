package com.andrew.frostycore.Managers;

import com.andrew.frostycore.Utils.ChatColorUtil;
import com.google.common.collect.Maps;

import java.util.Map;

public class RankManager {

    public static Map<String, Rank> ranks = Maps.newHashMap();

    public static Map<String, Rank> getRank(String rankName){
        return ranks;
    }

    public static Rank getRankName(String rankName){
        return ranks.get(rankName);
    }

    public RankManager() {
        Rank member = new Rank(1, "Member", false);
        member.setPrefix(RankPrefix.MEMBER.prefix);
        Rank knight = new Rank(2, "Knight", false);
        knight.setPrefix(RankPrefix.KNIGHT.prefix);
        Rank hero = new Rank(3, "Hero", false);
        hero.setPrefix(RankPrefix.HERO.prefix);
        Rank elite = new Rank(4, "Elite", false);
        elite.setPrefix(RankPrefix.ELITE.prefix);
        Rank ultra = new Rank(5, "Ultra", false);
        ultra.setPrefix(RankPrefix.ULTRA.prefix);
        Rank legend = new Rank(6, "Legend", false);
        legend.setPrefix(RankPrefix.LEGEND.prefix);
        Rank titan = new Rank(7, "Titan", false);
        titan.setPrefix(RankPrefix.TITAN.prefix);
        Rank wizard = new Rank(8, "Wizard", false);
        wizard.setPrefix(RankPrefix.WIZARD.prefix);
        Rank helper = new Rank(9, "Helper", true);
        helper.setPrefix(RankPrefix.HELPER.prefix);
        Rank moderator = new Rank(10, "Moderator", true);
        moderator.setPrefix(RankPrefix.MODERATOR.prefix);
        Rank administrator = new Rank(11, "Administrator", true);
        administrator.setPrefix(RankPrefix.ADMINISTRATOR.prefix);
        Rank owner = new Rank(12, "Owner", true);
        owner.setPrefix(RankPrefix.OWNER.prefix);
        ranks.put(member.getRankName(), member);
        ranks.put(knight.getRankName(), knight);
        ranks.put(hero.getRankName(), hero);
        ranks.put(elite.getRankName(), elite);
        ranks.put(ultra.getRankName(), ultra);
        ranks.put(legend.getRankName(), legend);
        ranks.put(titan.getRankName(), titan);
        ranks.put(wizard.getRankName(), wizard);
        ranks.put(helper.getRankName(), helper);
        ranks.put(moderator.getRankName(), moderator);
        ranks.put(administrator.getRankName(), administrator);
        ranks.put(owner.getRankName(), owner);

    }

    public Rank getPrefix(String rank) {
        return ranks.get(rank);
    }

    public enum RankPrefix {
        MEMBER(ChatColorUtil.colorize("&8[&7&lMember&8]")),
        KNIGHT(ChatColorUtil.colorize("&8[&8&lKnight&8]")),
        HERO(ChatColorUtil.colorize("&8[&3&lHero&8]")),
        ELITE(ChatColorUtil.colorize("&8[&e&lElite&8]")),
        ULTRA(ChatColorUtil.colorize("&8[&d&lUltra&8]")),
        LEGEND(ChatColorUtil.colorize("&8[&b&lLegend&8]")),
        TITAN(ChatColorUtil.colorize("&8[&6&lTitan&8]")),
        WIZARD(ChatColorUtil.colorize("&8[&3&lWizard&8]")),

        // STAFF RANKS
        HELPER(ChatColorUtil.colorize("&8[&e&lHelper&8]")),
        MODERATOR(ChatColorUtil.colorize("&8[&d&lModerator&8]")),
        ADMINISTRATOR(ChatColorUtil.colorize("&8[&c&lAdministrator&8]")),
        OWNER(ChatColorUtil.colorize("&8[&4&lOwner&8]"));

        private String prefix;

        RankPrefix(String prefix) {
            this.prefix = prefix;
        }

        public String getPrefix() {
            return prefix;
        }

        public void setPrefix(String prefix) {
            this.prefix = prefix;
        }
    }
}
