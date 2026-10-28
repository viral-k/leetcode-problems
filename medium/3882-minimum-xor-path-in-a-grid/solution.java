/**
 * 3882. Minimum XOR Path in a Grid
 * Time: O(m * n * V), V = 1024
 * Space: O(n * V)
 */
class Solution {
    private static final int V = 1024;  // values are at most 1023, so XORs fit in 10 bits

    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // prev[c][x] is true if some path reaches (r - 1, c) with XOR x
        boolean[][] prev = new boolean[n][V];
        boolean[][] cur = new boolean[n][V];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                boolean[] out = cur[c];
                java.util.Arrays.fill(out, false);
                int v = grid[r][c];

                if (r == 0 && c == 0) {
                    out[v] = true;
                    continue;
                }
                for (int x = 0; x < V; x++) {
                    boolean seen = (r > 0 && prev[c][x]) || (c > 0 && cur[c - 1][x]);
                    if (seen) {
                        out[x ^ v] = true;
                    }
                }
            }
            boolean[][] tmp = prev;
            prev = cur;
            cur = tmp;
        }

        boolean[] last = prev[n - 1];
        for (int x = 0; x < V; x++) {
            if (last[x]) {
                return x;
            }
        }
        return -1;  // unreachable: the end cell always has at least one path
    }
}
