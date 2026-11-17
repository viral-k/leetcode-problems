import java.util.*;

/**
 * 2911. Minimum Changes to Make K Semi-palindromes
 * Time: O(n^2 log n + k * n^2)
 * Space: O(n^2)
 */
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        char[] c = s.toCharArray();
        final int INF = Integer.MAX_VALUE / 2;

        // cost[i][j] = fewest changes to make s[i..j] a semi-palindrome.
        // Length-1 substrings have no valid divisor and stay INF.
        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }
        int[][] g = new int[n][n];
        for (int d = 1; d <= n / 2; d++) {
            // g[a][b] = changes to make c[a], c[a+d], ..., c[b] a palindrome
            // (b - a a multiple of d). Peel the outer pair off the inner one.
            // Every entry read below is written earlier for this same d.
            for (int t = 1; t * d <= n - 1; t++) {
                for (int a = 0; a + t * d < n; a++) {
                    int b = a + t * d;
                    int inner = t >= 2 ? g[a + d][b - d] : 0;
                    g[a][b] = inner + (c[a] != c[b] ? 1 : 0);
                }
            }
            // Substrings whose length is a multiple of d, at least 2 * d, so
            // d is a proper divisor. Group r runs from i + r to j - d + 1 + r.
            for (int len = 2 * d; len <= n; len += d) {
                for (int i = 0; i + len <= n; i++) {
                    int j = i + len - 1;
                    int sum = 0;
                    for (int r = 0; r < d; r++) {
                        sum += g[i + r][j - d + 1 + r];
                    }
                    cost[i][j] = Math.min(cost[i][j], sum);
                }
            }
        }

        // dp[j] = best way to split s[0..j) into p pieces, each of length >= 2.
        int[] dp = new int[n + 1];
        Arrays.fill(dp, INF);
        for (int j = 2; j <= n; j++) {
            dp[j] = cost[0][j - 1];
        }
        for (int p = 2; p <= k; p++) {
            int[] next = new int[n + 1];
            Arrays.fill(next, INF);
            for (int j = 2 * p; j <= n; j++) {
                // the last piece is s[i..j); the first p - 1 pieces need 2(p - 1) chars
                for (int i = 2 * (p - 1); i <= j - 2; i++) {
                    next[j] = Math.min(next[j], dp[i] + cost[i][j - 1]);
                }
            }
            dp = next;
        }
        return dp[n];
    }
}
