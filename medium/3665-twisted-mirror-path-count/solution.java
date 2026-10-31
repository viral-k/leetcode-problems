/**
 * 3665. Twisted Mirror Path Count
 * Time: O(m * n)
 * Space: O(n)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int uniquePaths(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // down[j] = ways to enter (i, j) moving down, filled by the row above.
        int[] down = new int[n];
        for (int i = 0; i < m; i++) {
            int[] next = new int[n];
            // right = ways to enter (i, j) moving right, from (i, j - 1).
            int right = 0;
            for (int j = 0; j < n; j++) {
                int r = right, d = down[j];
                if (i == 0 && j == 0) {
                    r = 1;
                    d = 0;
                }
                int total = (int) (((long) r + d) % MOD);
                if (i == m - 1 && j == n - 1) {
                    return total;
                }
                if (grid[i][j] == 1) {
                    // Mirror: moving right turns down, moving down turns right.
                    next[j] = r;
                    right = d;
                } else {
                    next[j] = total;
                    right = total;
                }
            }
            // right leaving column n - 1 and next leaving row m - 1 fall off the grid.
            down = next;
        }
        return 0;
    }
}
