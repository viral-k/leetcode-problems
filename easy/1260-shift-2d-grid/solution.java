import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1260. Shift 2D Grid
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int total = m * n;
        k %= total; // full rotations are no-ops

        Integer[][] result = new Integer[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int newIdx = (i * n + j + k) % total;
                result[newIdx / n][newIdx % n] = grid[i][j];
            }
        }

        List<List<Integer>> out = new ArrayList<>();
        for (Integer[] row : result) {
            out.add(Arrays.asList(row));
        }
        return out;
    }
}
