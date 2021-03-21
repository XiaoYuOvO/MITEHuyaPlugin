package net.xiaoyu233.mitemod.huya.config;

import com.google.gson.JsonElement;
import com.sun.istack.internal.NotNull;

import javax.annotation.Nullable;

public abstract class Config {
    private final String name;
    public abstract JsonElement writeDefault();
    @NotNull
    public abstract ReadResult read(JsonElement json);

    protected Config(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static class ReadResult{
        private final boolean dirty;
        @Nullable
        private final JsonElement changed;

        private ReadResult(boolean dirty, @Nullable JsonElement changed) {
            this.dirty = dirty;
            this.changed = changed;
        }

        @Nullable
        public JsonElement getChanged() {
            return changed;
        }

        public boolean isDirty() {
            return dirty;
        }

        public static ReadResult ofChanged(JsonElement changed){
            return new ReadResult(true,changed);
        }

        public static final ReadResult NO_CHANGE = new ReadResult(false,null);
    }
}
