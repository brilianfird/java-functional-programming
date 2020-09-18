package com.example.functional.programming.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class SimpleStream<T> {

    private List<T> values;

    public SimpleStream(T... values) {
        this.values = Arrays.asList(values);
    }

    public SimpleStream(List<T> values) {
        this.values = values;
    }

    public SimpleStream<T> filter(Predicate<T> filter) {
        List<T> returnValueList = new ArrayList<>();
        for (T value : values) {
            if (filter.test(value)) {
                returnValueList.add(value);
            }
        }
        this.values = returnValueList;
        return this;
    }

    public SimpleStream<T> map(Function<T, T> function) {
        List<T> returnValueList = new ArrayList<>();
        for (T value : values) {
            returnValueList.add(function.apply(value));
        }
        this.values = returnValueList;
        return this;
    }

    public void forEach(Consumer<T> consumer) {
        for (T value : values) {
            consumer.accept(value);
        }
    }

    public List<T> toList() {
        return this.values;
    }

}
