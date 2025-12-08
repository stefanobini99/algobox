package com.stefano.algobox.algorithms.dp;

/**
 * Longest Common Subsequence (LCS) problem using iterative DP.
 */
public final class LCS {

    /**
     * Computes the length of the LCS between two strings.
     *
     * @param a first string
     * @param b second string
     * @return length of the longest common subsequence
     */
    public static int lcs(String a, String b) {
        int m = a.length(), n = b.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }
}
