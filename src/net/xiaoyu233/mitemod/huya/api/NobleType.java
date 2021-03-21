package net.xiaoyu233.mitemod.huya.api;

import com.google.common.collect.Maps;
import net.xiaoyu233.fml.util.Utils;

import java.util.HashMap;

public enum NobleType {
    NONE(0,"无"),
    SWORDS_MAN(1,"剑士"),
    KNIGHT(2,"骑士"),
    SEIGNIOR(3,"领主"),
    DUKE(4,"公爵"),
    KING(5,"君王"),
    EMPEROR(6,"帝皇"),
    LEGENDARY_EMPEROR(7,"超神帝皇");
    private final int level;
    private final String cnName;
    NobleType(int level,String cnName){
        this.level = level;
        this.cnName = cnName;
    }

    public String getCnName() {
        return cnName;
    }

    public int getLevel() {
        return level;
    }

    private static final HashMap<Integer, NobleType> levelToNobleType = Utils.make(new HashMap<>(),(map) -> {
        for (NobleType value : NobleType.values()) {
            map.put(value.getLevel(),value);
        }
    });

    public static NobleType getFromLevel(int level){
        return levelToNobleType.get(level);
    }
}
