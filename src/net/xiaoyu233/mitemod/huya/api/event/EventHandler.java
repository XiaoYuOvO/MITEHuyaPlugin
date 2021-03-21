package net.xiaoyu233.mitemod.huya.api.event;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import net.xiaoyu233.mitemod.huya.HuyaMod;
import org.java_websocket.handshake.ServerHandshake;

import java.util.*;
import java.util.function.Consumer;

@SuppressWarnings("unchecked")
public class EventHandler {
    private final List<CloseListener> closeListeners = Lists.newArrayList();
    private final List<Consumer<Exception>> errorListeners = Lists.newArrayList();
    private final List<Consumer<ServerHandshake>> openListeners = Lists.newArrayList();
    private final Map<EventType<?>, List<EventListener<Event>>> listeners = Maps.newHashMap();

    public EventHandler() {

    }

    public Set<EventType<?>> getListeners() {
        return listeners.keySet();
    }

    public void addCloseListener(CloseListener listener){
        this.closeListeners.add(listener);
    }

    public void  addErrorListener(Consumer<Exception> listener) {
        this.errorListeners.add(listener);
    }

    public <T extends Event> void registerListener(EventType<T> eventType, EventListener<T> listener){
        this.listeners.computeIfAbsent(eventType, (type) -> new ArrayList<>()).add((EventListener<Event>) listener);
    }

    public void addOpenListener(Consumer<ServerHandshake> listener){
        this.openListeners.add(listener);
    }

    public void onOpen(ServerHandshake arg0) {
        this.openListeners.forEach((listener -> listener.accept(arg0)));
    }

    @FunctionalInterface
    public interface CloseListener{
        void onClose(int code, String reason, boolean remote);
    }
    public void onClose(int code, String reason, boolean remote) {
        this.closeListeners.forEach((listeners -> listeners.onClose(code, reason, remote)));
    }

    public void onError(Exception arg0) {
        this.errorListeners.forEach((listeners) -> listeners.accept(arg0));
    }

    public void onMessage(String arg0) {
        try {
            JsonObject res = ((JsonObject) new JsonParser().parse(arg0));
            if("command".equals(res.get("notice").getAsString())) {//监听成功回包
                List<EventType<?>> succeededEvents = new ArrayList<>();
                for (JsonElement jsonElement : res.get("data").getAsJsonObject().get("data").getAsJsonArray()) {
                    if (jsonElement.isJsonPrimitive()) {
                        succeededEvents.add(EventType.byName(jsonElement.getAsString()));
                    }
                }
                this.listeners.keySet().removeIf((type -> !succeededEvents.contains(type)));
                HuyaMod.LOGGER.info("Successfully listened:" + Arrays.toString(succeededEvents.toArray()));
            }
            String notice = res.get("notice").getAsString();
            if (EventType.hasRegistered(notice)){
                EventType<?> eventType = EventType.byName(notice);
                Event data1 = eventType.getFromJson(res.get("data").getAsJsonObject());
                if (!this.listeners.isEmpty()){
                    for (EventListener<Event> eventListener : this.listeners.get(eventType)) {
                        eventListener.handleEvent(data1);
                    }
                }
            }
        } catch (Exception e) {
            HuyaMod.LOGGER.error("Error in precessing message",e);
        }
    }
}
