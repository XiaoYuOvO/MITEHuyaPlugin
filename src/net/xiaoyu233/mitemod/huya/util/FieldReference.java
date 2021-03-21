package net.xiaoyu233.mitemod.huya.util;

import java.util.Objects;
import java.util.function.Supplier;

public class FieldReference<T> implements Supplier<T> {
    private T value;

    public FieldReference(T defaultValue){
        this.value = defaultValue;
    }

    public FieldReference(){}

    public T get() {
        return value;
    }

    public void set(T value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FieldReference<?> that = (FieldReference<?>) o;
        return value.equals(that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
