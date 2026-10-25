/**
 * 1254. Number of Closed Islands
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] stack = new int[m * n];  // cells encoded as r * n + c
        int count = 0;

        for (int sr = 0; sr < m; sr++) {
            for (int sc = 0; sc < n; sc++) {
                if (grid[sr][sc] != 0) {
                    continue;
                }

                // flood the whole island even after it touches the border,
                // otherwise its leftover cells get counted as a new island
                boolean closed = true;
                int top = 0;
                grid[sr][sc] = 1;
                stack[top++] = sr * n + sc;
                while (top > 0) {
                    int cell = stack[--top];
                    int r = cell / n, c = cell % n;
                    if (r == 0 || c == 0 || r == m - 1 || c == n - 1) {
                        closed = false;
                    }
                    for (int[] d : DIRS) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 0) {
                            grid[nr][nc] = 1;
                            stack[top++] = nr * n + nc;
                        }
                    }
                }

                if (closed) {
                    count++;
                }
            }
        }

        return count;
    }
}
