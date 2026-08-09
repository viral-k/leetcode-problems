/**
 * 1563. Stone Game V
 * Time: O(n^2)
 * Space: O(n^2)
 */
class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        if (n < 2) {
            return 0;
        }

        // Prefix sums: sum(i..j) = P[j+1] - P[i]
        long[] P = new long[n + 1];
        for (int i = 0; i < n; i++) {
            P[i + 1] = P[i] + stoneValue[i];
        }

        int[][] dp = new int[n][n];
        int[][] mL = new int[n][n]; // mL[i][k] = max_{k'<=k} (sum(i..k') + dp[i][k'])
        int[][] mR = new int[n][n]; // mR[k][j] = max_{k'>=k} (sum(k'..j) + dp[k'][j])

        for (int i = n - 1; i >= 0; i--) {
            mL[i][i] = stoneValue[i];
            mR[i][i] = stoneValue[i];
            int p = i; // monotone split threshold for this i
            for (int j = i + 1; j < n; j++) {
                long total = P[j + 1] - P[i];
                // smallest k in [i, j-1] with 2 * sum(i..k) >= total (else p == j)
                while (p < j && 2 * (P[p + 1] - P[i]) < total) {
                    p++;
                }

                // a tie at k == p lets Alice also keep the left side
                int lb = (p <= j - 1 && 2 * (P[p + 1] - P[i]) == total) ? p : p - 1;

                int best = 0;
                if (lb >= i) {
                    best = mL[i][lb];
                }
                if (p + 1 <= j && mR[p + 1][j] > best) {
                    best = mR[p + 1][j];
                }
                dp[i][j] = best;

                int span = (int) (total + best); // sum(i..j) + dp[i][j]
                mL[i][j] = Math.max(mL[i][j - 1], span);
                mR[i][j] = Math.max(mR[i + 1][j], span);
            }
        }

        return dp[0][n - 1];
    }
}
