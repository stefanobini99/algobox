package com.stefano.algobox.fp;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Functional utilities including function composition and currying.
 */
public final class FunctionUtils {

    private FunctionUtils() {}

    /**
     * Composes two functions: f1 then f2.
     *
     * @param f1 first function
     * @param f2 second function
     * @param <T> input type
     * @param <R> output type
     * @param <U> intermediate type
     * @return composed function
     */
    public static <T, U, R> Function<T, R> compose(Function<? super T, ? extends U> f1,
                                                   Function<? super U, ? extends R> f2) {
        return x -> f2.apply(f1.apply(x));
    }

    public static <T> Predicate<T> negate(Predicate<T> p) {
        return p.negate();
    }

    public static <T> T identity(T t) {
        return t;
    }
}
