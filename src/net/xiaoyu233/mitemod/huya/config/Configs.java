package net.xiaoyu233.mitemod.huya.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import net.xiaoyu233.mitemod.huya.HuyaMod;
import net.xiaoyu233.mitemod.huya.util.FieldReference;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Configs {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final File CONFIG_FILE = new File("./huya_config.json");
    public static final FieldReference<File> POINT_FILE = new FieldReference<>();
    public static class Authorization{
        public static final FieldReference<Integer> ROOM_ID = new FieldReference<>();
        public static final FieldReference<String> APP_ID = new FieldReference<>();
        public static final FieldReference<String> SECRET = new FieldReference<>();
    }
    public static final ConfigCategory CONFIG = new ConfigCategory("root").
            addEntry(new ConfigEntry<>("PointListFile",Codec.FILE, new File("./HuyaPoint.json"),POINT_FILE).withComment("分数表春初文件目录,一般无需更改")).
            addEntry(new ConfigCategory("Authorization").
                    addEntry(new ConfigEntry<>("AppId",Codec.STRING,"",Authorization.APP_ID).withComment("虎牙开发者AppId(必填)")).
                    addEntry(new ConfigEntry<>("Secret",Codec.STRING,"",Authorization.SECRET).withComment("虎牙开发者Secret(必填)")).
                    addEntry(new ConfigEntry<>("RoomId",Codec.INTEGER,-1,Authorization.ROOM_ID).withComment("监听的房间ID(必填)")));
    public static void loadConfig(){
        Config.ReadResult read = Config.ReadResult.NO_CHANGE;
        if (!CONFIG_FILE.exists()){
            try {
                if (!CONFIG_FILE.createNewFile()) {
                    HuyaMod.LOGGER.error("Cannot create config file");
                }else {
                    try (FileWriter writer = new FileWriter(CONFIG_FILE)){
                        GSON.toJson(CONFIG.writeDefault(),writer);
                    }
                }
            } catch (IOException e) {
                HuyaMod.LOGGER.error("Cannot create config file",e);
            }
        }
        try (FileReader reader = new FileReader(CONFIG_FILE)){
            read= CONFIG.read(new JsonParser().parse(reader));
        }catch (Throwable e) {
            HuyaMod.LOGGER.error("Error in reading config",e);
        }
        try {
            if (read.isDirty()){
                try (FileWriter writer = new FileWriter(CONFIG_FILE)){
                    GSON.toJson(read.getChanged(),writer);
                }
            }
        }catch (Throwable e) {
            HuyaMod.LOGGER.error("Error in writing config",e);
        }
    }
}
