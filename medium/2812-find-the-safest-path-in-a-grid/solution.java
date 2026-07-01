import java.util.ArrayDeque;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 2812. Find the Safest Path in a Grid
 * Time: O(n^2 log n)
 * Space: O(n^2)
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        // Phase 1: multi-source BFS -> Manhattan distance to nearest thief.
        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            java.util.Arrays.fill(row, -1);
        }
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid.get(r).get(c) == 1) {
                    dist[r][c] = 0;
                    queue.add(new int[]{r, c});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            for (int[] d : DIRS) {
                int nr = cell[0] + d[0], nc = cell[1] + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && dist[nr][nc] == -1) {
                    dist[nr][nc] = dist[cell[0]][cell[1]] + 1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }

        // Phase 2: max-min (bottleneck) path via max-heap Dijkstra.
        int[][] best = new int[n][n];
        for (int[] row : best) {
            java.util.Arrays.fill(row, -1);
        }
        best[0][0] = dist[0][0];
        // {bottleneck, r, c}, ordered by bottleneck descending
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        heap.add(new int[]{dist[0][0], 0, 0});
        while (!heap.isEmpty()) {
            int[] top = heap.poll();
            int b = top[0], r = top[1], c = top[2];
            if (r == n - 1 && c == n - 1) {
                return b;
            }
            if (b < best[r][c]) {
                continue;
            }
            for (int[] d : DIRS) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n) {
                    int nb = Math.min(b, dist[nr][nc]);
                    if (nb > best[nr][nc]) {
                        best[nr][nc] = nb;
                        heap.add(new int[]{nb, nr, nc});
                    }
                }
            }
        }
        return best[n - 1][n - 1];
    }
}
