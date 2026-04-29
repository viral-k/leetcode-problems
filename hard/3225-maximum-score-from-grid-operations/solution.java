/**
 * 3225. Maximum Score From Grid Operations
 * Time: O(n^3)
 * Space: O(n^2)
 */
class Solution {
    public long maximumScore(int[][] grid) {
        int n = grid.length;

        // Precompute prefix sums for each column
        long[][] psum = new long[n][n + 1];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < n; i++) {
                psum[j][i + 1] = psum[j][i] + grid[i][j];
            }
        }

        long NEG_INF = Long.MIN_VALUE / 2;

        // dp[a][b] = max score, h[prev_col] = a, h[curr_col] = b
        long[][] dp = new long[n + 1][n + 1];
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {
                dp[a][b] = (a == 0) ? 0 : NEG_INF;
            }
        }

        for (int j = 0; j < n - 1; j++) {
            long[][] suffix = new long[n + 2][n + 1];
            long[][] prefix = new long[n + 2][n + 1];

            for (int b = 0; b <= n; b++) {
                suffix[n + 1][b] = NEG_INF;
                for (int a = n; a >= 0; a--) {
                    suffix[a][b] = Math.max(dp[a][b] + psum[j][a], suffix[a + 1][b]);
                }

                prefix[0][b] = NEG_INF;
                for (int a = 1; a <= n + 1; a++) {
                    long prevDp = (a - 1 <= n) ? dp[a - 1][b] : NEG_INF;
                    prefix[a][b] = Math.max(prefix[a - 1][b], prevDp);
                }
            }

            long[][] newDp = new long[n + 1][n + 1];
            for (int i = 0; i <= n; i++) {
                for (int k = 0; k <= n; k++) {
                    newDp[i][k] = NEG_INF;
                }
            }

            for (int b = 0; b <= n; b++) {
                // Case: c <= b
                long val = Math.max(suffix[b + 1][b] - psum[j][b], prefix[b + 1][b]);
                for (int c = 0; c <= b; c++) {
                    newDp[b][c] = val;
                }

                // Case: c > b
                for (int c = b + 1; c <= n; c++) {
                    val = Math.max(suffix[c][b], prefix[c][b] + psum[j][c]) - psum[j][b];
                    newDp[b][c] = val;
                }
            }

            dp = newDp;
        }

        // Final: add column n-1's contribution
        long ans = 0;
        for (int a = 0; a <= n; a++) {
            for (int b = 0; b <= n; b++) {
                if (dp[a][b] == NEG_INF) continue;
                long contrib = (a > b) ? psum[n - 1][a] - psum[n - 1][b] : 0;
                ans = Math.max(ans, dp[a][b] + contrib);
            }
        }

        return ans;
    }
}
