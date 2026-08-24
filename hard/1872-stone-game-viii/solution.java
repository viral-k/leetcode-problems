/**
 * 1872. Stone Game VIII
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int stoneGameVIII(int[] stones) {
        int n = stones.length;
        long[] prefix = new long[n];
        prefix[0] = stones[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + stones[i];
        }

        // dp = best difference for the player to move, picks allowed from i onward.
        // At the last index the player must take everything remaining.
        long dp = prefix[n - 1];
        for (int i = n - 2; i >= 1; i--) {
            // stop here and bank prefix[i], or pass the same options forward
            dp = Math.max(prefix[i] - dp, dp);
        }
        return (int) dp;
    }
}
