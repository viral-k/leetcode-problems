import java.util.Arrays;

/**
 * 3742. Maximum Path Score in a Grid
 * Time:  O(m * n * min(k, m + n - 1))
 * Space: O(n * min(k, m + n - 1))  -- rolling rows
 */
class Solution {
    public int maxPathScore(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int K = Math.min(k, m + n - 1);
        final int NEG = Integer.MIN_VALUE / 2;

        int[][] prev = new int[n][K + 1];
        for (int[] row : prev) Arrays.fill(row, NEG);
        prev[0][0] = 0; // grid[0][0] == 0 by constraint

        for (int j = 1; j < n; j++) {
            int val = grid[0][j];
            int cost = val == 0 ? 0 : 1;
            for (int c = cost; c <= K; c++) {
                int left = prev[j - 1][c - cost];
                if (left > NEG) {
                    prev[j][c] = left + val;
                }
            }
        }

        int[][] curr = new int[n][K + 1];

        for (int i = 1; i < m; i++) {
            for (int[] row : curr) Arrays.fill(row, NEG);

            int val0 = grid[i][0];
            int cost0 = val0 == 0 ? 0 : 1;
            for (int c = cost0; c <= K; c++) {
                int top = prev[0][c - cost0];
                if (top > NEG) {
                    curr[0][c] = top + val0;
                }
            }

            for (int j = 1; j < n; j++) {
                int val = grid[i][j];
                int cost = val == 0 ? 0 : 1;
                int[] topRow = prev[j];
                int[] leftRow = curr[j - 1];
                int[] curRow = curr[j];
                for (int c = cost; c <= K; c++) {
                    int t = topRow[c - cost];
                    int l = leftRow[c - cost];
                    int best = t > l ? t : l;
                    if (best > NEG) {
                        curRow[c] = best + val;
                    }
                }
            }

            int[][] tmp = prev;
            prev = curr;
            curr = tmp;
        }

        int ans = NEG;
        for (int c = 0; c <= K; c++) {
            if (prev[n - 1][c] > ans) ans = prev[n - 1][c];
        }
        return ans <= NEG ? -1 : ans;
    }
}
