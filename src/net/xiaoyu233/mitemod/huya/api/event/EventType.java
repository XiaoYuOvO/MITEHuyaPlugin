package net.xiaoyu233.mitemod.huya.api.event;

import com.google.common.collect.Maps;
import com.google.gson.JsonObject;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.function.Function;

public class EventType <T extends Event>{
    //Must put at first
    private static final Map<String,EventType<?>> TYPES = Maps.newHashMap();
    public static final EventType<PresentEvent> PRESENT_TYPE = EventType.register("getSendItemNotice",PresentEvent::new);
    public static final EventType<MessageEvent> MESSAGE_EVENT = EventType.register("getMessageNotice",MessageEvent::new);
    private final Function<JsonObject, T> factory;
    private final String name;
    private EventType(Function<JsonObject, T> factory,String name){
        this.factory = factory;
        this.name = name;
    }

    public T getFromJson(JsonObject o){
        return this.factory.apply(o);
    }

    public static EventType<?> byName(String name){
        return TYPES.get(name);
    }

    public static boolean hasRegistered(String eventType) {
           return TYPES.containsKey(eventType);
    }

    public String getName() {
        return name;
    }

    @Nonnull
    public static <T extends Event> EventType<T> register(String name,@Nonnull Function<JsonObject, T> factory){
        EventType<T> tEventType = new EventType<>(factory,name);
        TYPES.put(name,tEventType);
        return tEventType;
    }

    @Override
    public String toString() {
        return name;
    }
}
