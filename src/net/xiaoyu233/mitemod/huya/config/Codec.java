package net.xiaoyu233.mitemod.huya.config;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.io.File;

public interface Codec<T> {
    Codec<Integer> INTEGER = new Codec<Integer>() {
        @Override
        public JsonElement write(Integer value) {
            return new JsonPrimitive(value);
        }

        @Override
        public Integer read(JsonElement json) {
            return json.getAsInt();
        }
    };
    Codec<Double> DOUBLE = new Codec<Double>() {
        @Override
        public JsonElement write(Double value) {
            return new JsonPrimitive(value);
        }

        @Override
        public Double read(JsonElement json) {
            return json.getAsDouble();
        }
    };
    Codec<String> STRING = new Codec<String>() {
        @Override
        public JsonElement write(String value) {
            return new JsonPrimitive(value);
        }

        @Override
        public String read(JsonElement json) {
            return json.getAsString();
        }
    };
    Codec<File> FILE = new Codec<File>() {
        @Override
        public JsonElement write(File value) {
            return new JsonPrimitive(value.toString());
        }

        @Override
        public File read(JsonElement json) {
            return new File(json.getAsString());
        }
    };
    Codec<Boolean> BOOLEAN = new Codec<Boolean>() {
        @Override
        public JsonElement write(Boolean value) {
            return new JsonPrimitive(value);
        }

        @Override
        public Boolean read(JsonElement json) {
            return json.getAsBoolean();
        }
    };
    JsonElement write(T value);
    T read(JsonElement json);
}
