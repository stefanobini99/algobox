package com.stefano.algobox.fp;

import java.util.function.Function;

public class HigherOrderFunctions {

    // Accepts a transformation and applies it twice
    public static <T> T applyTwice(Function<T, T> function, T value) {
        return function.apply(function.apply(value));
    }
}
