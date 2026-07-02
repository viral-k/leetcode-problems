import java.util.ArrayDeque;
import java.util.List;

/**
 * 3286. Find a Safe Walk Through a Grid
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size(), n = grid.get(0).size();
        int[][] dist = new int[m][n];
        for (int[] row : dist) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }
        dist[0][0] = grid.get(0).get(0);
        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.addFirst(new int[]{0, 0}); // front = smaller distance

        while (!dq.isEmpty()) {
            int[] cell = dq.pollFirst();
            int r = cell[0], c = cell[1], d = dist[r][c];
            for (int[] dir : DIRS) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n) {
                    int w = grid.get(nr).get(nc);
                    int nd = d + w;
                    if (nd < dist[nr][nc]) {
                        dist[nr][nc] = nd;
                        if (w == 0) {
                            dq.addFirst(new int[]{nr, nc});
                        } else {
                            dq.addLast(new int[]{nr, nc});
                        }
                    }
                }
            }
        }

        return health - dist[m - 1][n - 1] >= 1;
    }
}
