/**
 * 3619. Count Islands With Total Value Divisible by K
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int countIslands(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;
        int[] stack = new int[m * n];  // cells encoded as r * n + c
        int count = 0;

        for (int sr = 0; sr < m; sr++) {
            for (int sc = 0; sc < n; sc++) {
                if (grid[sr][sc] == 0) {
                    continue;
                }

                // Keep the total mod k. It stays below k <= 1e6, and adding a
                // cell keeps it under 2e6, so an int never overflows.
                int remainder = grid[sr][sc] % k;
                grid[sr][sc] = 0;
                int top = 0;
                stack[top++] = sr * n + sc;
                while (top > 0) {
                    int cell = stack[--top];
                    int r = cell / n, c = cell % n;
                    for (int[] d : DIRS) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] > 0) {
                            remainder = (remainder + grid[nr][nc]) % k;
                            grid[nr][nc] = 0;
                            stack[top++] = nr * n + nc;
                        }
                    }
                }

                if (remainder == 0) {
                    count++;
                }
            }
        }

        return count;
    }
}
