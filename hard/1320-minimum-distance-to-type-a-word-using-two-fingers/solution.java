import java.util.Arrays;

/**
 * 1320. Minimum Distance to Type a Word Using Two Fingers
 * Time: O(n × 27)
 * Space: O(27)
 */
class Solution {
    public int minimumDistance(String word) {
        int[] dp = new int[27];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[26] = 0;  // other finger is free initially

        int prev = word.charAt(0) - 'A';

        for (int i = 1; i < word.length(); i++) {
            int curr = word.charAt(i) - 'A';
            int[] newDp = new int[27];
            Arrays.fill(newDp, Integer.MAX_VALUE);

            for (int j = 0; j < 27; j++) {
                if (dp[j] == Integer.MAX_VALUE) continue;

                // Option 1: Use finger at prev
                int cost1 = dp[j] + dist(prev, curr);
                newDp[j] = Math.min(newDp[j], cost1);

                // Option 2: Use finger at j
                int cost2 = dp[j] + dist(j, curr);
                newDp[prev] = Math.min(newDp[prev], cost2);
            }

            dp = newDp;
            prev = curr;
        }

        int ans = Integer.MAX_VALUE;
        for (int v : dp) {
            ans = Math.min(ans, v);
        }
        return ans;
    }

    private int dist(int c1, int c2) {
        if (c1 == 26) return 0;  // finger not yet placed
        int r1 = c1 / 6, col1 = c1 % 6;
        int r2 = c2 / 6, col2 = c2 % 6;
        return Math.abs(r1 - r2) + Math.abs(col1 - col2);
    }
}
