import java.util.*;

/**
 * 2463. Minimum Total Distance Traveled
 * Time: O(n × m) where m = sum of factory limits
 * Space: O(n × m)
 */
class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);

        // Expand factories into individual slots
        List<Integer> slots = new ArrayList<>();
        for (int[] f : factory) {
            for (int i = 0; i < f[1]; i++) {
                slots.add(f[0]);
            }
        }

        int n = robot.size(), m = slots.size();

        // dp[i][j] = min distance to assign first i robots to first j slots
        long[][] dp = new long[n + 1][m + 1];

        // Initialize with infinity
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE / 2);
        }

        // Base case: 0 robots need 0 distance (dp[0][j] = 0 by default)

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // Don't use slot j for robot i
                dp[i][j] = dp[i][j - 1];

                // Use slot j for robot i
                long dist = Math.abs(robot.get(i - 1) - slots.get(j - 1));
                dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + dist);
            }
        }

        return dp[n][m];
    }
}
