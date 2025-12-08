package com.stefano.algobox.algorithms.dp;

import java.util.HashMap;
import java.util.Map;

/**
 * Fibonacci sequence implementations demonstrating naive recursion, memoization, and DP.
 */
public final class Fibonacci {

    /**
     * Naive recursive approach (exponential time).
     */
    public static long naive(int n) {
        if (n <= 1) return n;
        return naive(n - 1) + naive(n - 2);
    }

    /**
     * Memoized recursive approach (top-down DP).
     */
    public static long memoized(int n) {
        return memoized(n, new HashMap<>());
    }

    private static long memoized(int n, Map<Integer, Long> cache) {
        if (n <= 1) return n;
        if (cache.containsKey(n)) return cache.get(n);
        long result = memoized(n - 1, cache) + memoized(n - 2, cache);
        cache.put(n, result);
        return result;
    }

    /**
     * Iterative bottom-up DP approach.
     */
    public static long iterative(int n) {
        if (n <= 1) return n;
        long[] dp = new long[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) dp[i] = dp[i - 1] + dp[i - 2];
        return dp[n];
    }
}
