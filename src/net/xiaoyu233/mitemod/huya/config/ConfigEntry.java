package net.xiaoyu233.mitemod.huya.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.xiaoyu233.mitemod.huya.HuyaMod;
import net.xiaoyu233.mitemod.huya.util.FieldReference;

import javax.swing.table.TableRowSorter;

public class ConfigEntry<T> extends Config{
    private final Codec<T> codec;
    private final T defaultValue;
    private final FieldReference<T> configRef;
    protected String comment = null;
    protected ConfigEntry(String name, Codec<T> codec, T defaultValue, FieldReference<T> configRef) {
        super(name);
        this.codec = codec;
        this.defaultValue = defaultValue;
        this.configRef = configRef;
    }

    @Override
    public JsonElement writeDefault() {
        if (this.comment != null){
            JsonObject json = new JsonObject();
            json.addProperty("_comment",this.comment);
            json.add("value",this.codec.write(this.defaultValue));
            return json;
        }
        return this.codec.write(this.defaultValue);
    }

    @Override
    public ReadResult read(JsonElement json) {
        try {
            if (json.isJsonObject()){
                this.configRef.set(this.codec.read(json.getAsJsonObject().get("value")));
            }else {
                this.configRef.set(this.codec.read(json));
            }
            return ReadResult.NO_CHANGE;
        }catch (Throwable t) {
            HuyaMod.LOGGER.error("Cannot read config: " + this.getName(),t);
            this.configRef.set(this.defaultValue);
            return ReadResult.ofChanged(this.writeDefault());
        }
    }

    public ConfigEntry<T> withComment(String comment) {
        this.comment = comment;
        return this;
    }

    public T getDefaultValue() {
        return defaultValue;
    }
}
