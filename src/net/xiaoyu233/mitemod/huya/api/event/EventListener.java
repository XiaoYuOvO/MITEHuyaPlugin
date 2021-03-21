package net.xiaoyu233.mitemod.huya.api.event;

@FunctionalInterface
public interface EventListener<T extends Event> {
    void handleEvent(T event);
}
