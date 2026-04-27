import java.util.*;

/**
 * 1391. Check if There is a Valid Path in a Grid
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Solution {
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        if (m == 1 && n == 1) {
            return true;
        }

        // Directions: 0=up, 1=right, 2=down, 3=left
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int[] opposite = {2, 3, 0, 1};

        // Which directions each street connects (as bitmask)
        // bit 0=up, bit 1=right, bit 2=down, bit 3=left
        int[] connections = {
            0,          // placeholder for index 0
            0b1010,     // 1: right(1), left(3)
            0b0101,     // 2: up(0), down(2)
            0b1100,     // 3: down(2), left(3)
            0b0110,     // 4: right(1), down(2)
            0b1001,     // 5: up(0), left(3)
            0b0011      // 6: up(0), right(1)
        };

        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int i = cell[0], j = cell[1];

            if (i == m - 1 && j == n - 1) {
                return true;
            }

            for (int d = 0; d < 4; d++) {
                // Check if current cell connects in this direction
                if ((connections[grid[i][j]] & (1 << d)) == 0) {
                    continue;
                }

                int ni = i + dirs[d][0], nj = j + dirs[d][1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    // Check if neighbor connects back
                    if ((connections[grid[ni][nj]] & (1 << opposite[d])) != 0) {
                        visited[ni][nj] = true;
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }
        }

        return false;
    }
}
