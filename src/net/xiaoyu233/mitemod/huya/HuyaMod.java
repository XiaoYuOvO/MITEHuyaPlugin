package net.xiaoyu233.mitemod.huya;

import net.xiaoyu233.fml.AbstractMod;
import net.xiaoyu233.fml.FishModLoader;
import net.xiaoyu233.fml.asm.annotations.Dist;
import net.xiaoyu233.fml.asm.annotations.Mod;
import net.xiaoyu233.mitemod.huya.api.event.EventHandler;
import net.xiaoyu233.mitemod.huya.config.Config;
import net.xiaoyu233.mitemod.huya.config.Configs;
import net.xiaoyu233.mitemod.huya.util.Constant;
import net.xiaoyu233.mitemod.huya.websocket.EventClient;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.net.URI;

@Mod({Dist.SERVER})
public class HuyaMod extends AbstractMod {
    public static final Logger LOGGER = LogManager.getLogger();
    @Override
    public void preInit() {

    }

    @Override
    public void postInit() {
        super.postInit();
        if (FishModLoader.isServer()){
            Configs.loadConfig();
            EventHandler eventHandler = new EventHandler();
            new EventClient(URI.create("ws://ws-apiext.huya.com/index.html"),Configs.Authorization.APP_ID.get(),Configs.Authorization.SECRET.get(),Configs.Authorization.ROOM_ID.get(),eventHandler);
        }
    }

    @Override
    public String modId() {
        return "mite-huya";
    }

    @Override
    public int modVerNum() {
        return Constant.VERSION_NUM;
    }

    @Override
    public String modVerStr() {
        return Constant.VERSION_NAME;
    }

    @Override
    public String transformPkg() {
        return "net.xiaoyu233.mitemod.huya.trans";
    }

}
