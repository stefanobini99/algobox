package com.stefano.algobox.fp;

import java.util.function.Function;

/**
 * Higher-order functions for functional programming examples.
 */
public class HigherOrderFunctions {

    /**
     * Applies a function twice to a value.
     *
     * @param function function to apply
     * @param value    initial value
     * @param <T>      type of value
     * @return result of applying function twice
     */
    public static <T> T applyTwice(Function<T, T> function, T value) {
        return function.apply(function.apply(value));
    }
}
