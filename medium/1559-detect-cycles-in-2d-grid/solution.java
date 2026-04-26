/**
 * 1559. Detect Cycles in 2D Grid
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Solution {
    private int m, n;
    private char[][] grid;
    private boolean[][] visited;
    private int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public boolean containsCycle(char[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid[i][j])) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int i, int j, int pi, int pj, char c) {
        visited[i][j] = true;

        for (int[] d : dirs) {
            int ni = i + d[0], nj = j + d[1];

            if (ni >= 0 && ni < m && nj >= 0 && nj < n && grid[ni][nj] == c) {
                if (!visited[ni][nj]) {
                    if (dfs(ni, nj, i, j, c)) {
                        return true;
                    }
                } else if (ni != pi || nj != pj) {
                    return true;
                }
            }
        }

        return false;
    }
}
