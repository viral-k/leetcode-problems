/**
 * 1140. Stone Game II
 * Time: O(n^3)
 * Space: O(n^2)
 */
class Solution {
    private int n;
    private int[] suffix;
    private int[][] memo;

    public int stoneGameII(int[] piles) {
        n = piles.length;

        // suffix[i] = sum of piles[i:]
        suffix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }

        memo = new int[n][n + 1];
        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }
        return dp(0, 1);
    }

    /** Max stones the current player can take from piles[i:]. */
    private int dp(int i, int M) {
        if (i >= n) {
            return 0;
        }
        if (2 * M >= n - i) {
            return suffix[i]; // can take everything that remains
        }
        if (memo[i][M] != -1) {
            return memo[i][M];
        }
        int best = 0;
        for (int x = 1; x <= 2 * M; x++) {
            // opponent then plays optimally on the rest
            best = Math.max(best, suffix[i] - dp(i + x, Math.max(M, x)));
        }
        memo[i][M] = best;
        return best;
    }
}
