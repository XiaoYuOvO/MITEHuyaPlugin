package net.xiaoyu233.mitemod.huya.websocket;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.xiaoyu233.mitemod.huya.api.event.EventHandler;
import net.xiaoyu233.mitemod.huya.api.event.EventType;
import net.xiaoyu233.mitemod.huya.util.ParamsUtil;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.enums.ReadyState;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

public class EventClient extends WebSocketClient {
    private static final Gson gson = new Gson();
    private final EventHandler handler;
    private final List<EventType<?>> listenTypes = new ArrayList<>();
    public EventClient(URI serverUri,String appId,String secret,long roomId, EventHandler handler) {
        super(URI.create(serverUri.toString() + ParamsUtil.MapToUrlString(ParamsUtil.getWebSocketJwtParamsMap(appId, secret, roomId),true)));
        this.handler = handler;
        this.listenTypes.addAll(handler.getListeners());
        Runtime.getRuntime().addShutdownHook(new Thread(()->EventClient.this.closeConnection(0,"bye")));
    }

    @Override
    public void onOpen(ServerHandshake arg0) {
        this.handler.onOpen(arg0);
    }

    @Override
    public void onClose( int code, String reason, boolean remote) {
        this.handler.onClose(code, reason, remote);
    }

    @Override
    public void connect() {
        super.connect();
        this.waitForOpen();
        this.sendSubscriptMessage();
    }

    private void sendSubscriptMessage(){
        if (listenTypes.isEmpty()){
            throw new IllegalStateException("Didn't listen to any thing");
        }
        JsonObject commandObject = new JsonObject();
        commandObject.addProperty("command","subscribeNotice");
        JsonArray subscriptEvents = new JsonArray();
        for (EventType<?> listenType : this.listenTypes) {
            subscriptEvents.add(listenType.getName());
        }
        commandObject.add("data",subscriptEvents);
        commandObject.addProperty("reqId",System.currentTimeMillis());
        this.send(gson.toJson(commandObject));
    }

    public void loop(long timeToSleep){
        try {
        while (!this.isClosed()) {
            Thread.sleep(timeToSleep);
            this.send("ping");
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(Exception arg0) {
        this.handler.onError(arg0);
    }

    @Override
    public void onMessage(String arg0) {
        this.handler.onMessage(arg0);
    }

    private void waitForOpen(){
        while (!this.getReadyState().equals(ReadyState.OPEN)) {
        }
    }
}
