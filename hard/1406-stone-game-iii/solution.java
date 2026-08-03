/**
 * 1406. Stone Game III
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int[] dp = new int[n + 1]; // dp[i] = best (current - opponent) diff from index i

        for (int i = n - 1; i >= 0; i--) {
            int best = Integer.MIN_VALUE;
            int take = 0;
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                take += stoneValue[i + k - 1];
                best = Math.max(best, take - dp[i + k]);
            }
            dp[i] = best;
        }

        if (dp[0] > 0) {
            return "Alice";
        }
        if (dp[0] < 0) {
            return "Bob";
        }
        return "Tie";
    }
}
