package net.xiaoyu233.mitemod.huya.util;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.*;

public class GiftJsonToEnum {
    public static void main(String[] args) {
        if (args.length == 1) {
            File file = new File(args[0]);
            try(FileReader reader = new FileReader(file)) {
                JsonElement parse = new JsonParser().parse(reader);
                if (parse.isJsonArray()){
                    JsonArray asJsonArray = parse.getAsJsonArray();
                    for (JsonElement jsonElement : asJsonArray) {
                        if (jsonElement.isJsonObject()){
                            JsonObject asJsonObject = jsonElement.getAsJsonObject();

                            //HULIANG("虎粮","huliang",<giftId>,<prizeYb>,<prizeGoldbean>,<prizeSilverbean>);
                            System.out.println(
                                    asJsonObject.get("giftEnName").getAsString().toUpperCase() +
                                            "(" +
                                    asJsonObject.get("giftCnName").toString() + "," +
                                     asJsonObject.get("giftEnName").toString()+ "," +
                                    asJsonObject.get("giftId").getAsInt() + "," +
                                    asJsonObject.get("prizeYb").getAsDouble() + "," +
                                    asJsonObject.get("prizeGoldbean").getAsInt() + "," +
                                    asJsonObject.get("prizeSilverbean").getAsInt() + "),");
                        }
                    }
                }else {
                    System.err.println("Not a json array");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            System.err.println("Usage: GiftJsonToEnum <jsonFile>(JsonArray)");
        }
    }
}
