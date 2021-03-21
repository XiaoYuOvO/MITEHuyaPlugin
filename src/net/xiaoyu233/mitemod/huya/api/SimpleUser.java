package net.xiaoyu233.mitemod.huya.api;

import com.google.gson.JsonObject;

public class SimpleUser  extends HuyaUser{

    public SimpleUser(String nickName, String uniqueID) {
        super(nickName, uniqueID);
    }


    public static HuyaUser fromJson(JsonObject json){
        //TODO
        return new SimpleUser("Huya", "1111");
    }
}
