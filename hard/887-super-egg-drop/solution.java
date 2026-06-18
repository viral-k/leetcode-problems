/**
 * 887. Super Egg Drop
 * Time: O(k * m) ~ O(k log n)
 * Space: O(k)
 */
class Solution {
    public int superEggDrop(int k, int n) {
        // dp[j] = max floors resolvable with j eggs at the current move count.
        int[] dp = new int[k + 1];
        int moves = 0;

        while (dp[k] < n) {
            moves++;
            for (int j = k; j >= 1; j--) {
                dp[j] = dp[j] + dp[j - 1] + 1;
            }
        }

        return moves;
    }
}
