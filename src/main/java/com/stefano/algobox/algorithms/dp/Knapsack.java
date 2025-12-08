package com.stefano.algobox.algorithms.dp;

/**
 * Classic 0/1 Knapsack problem solved with dynamic programming (iterative DP).
 */
public final class Knapsack {

    /**
     * Solves the 0/1 knapsack problem using iterative DP.
     *
     * @param weights item weights
     * @param values  item values
     * @param W       maximum capacity
     * @return maximum achievable value
     */
    public static int knapsack(int[] weights, int[] values, int W) {
        int n = weights.length;
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(dp[i - 1][w],
                            dp[i - 1][w - weights[i - 1]] + values[i - 1]);
                } else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        return dp[n][W];
    }
}
