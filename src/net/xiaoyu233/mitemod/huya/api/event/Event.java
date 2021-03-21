package net.xiaoyu233.mitemod.huya.api.event;

import com.google.gson.JsonObject;

import java.util.function.Function;

public abstract class Event {
    private final String eventName;

    protected Event(String eventName) {
        this.eventName = eventName;
    }

    public String getEventName() {
        return eventName;
    }
}
