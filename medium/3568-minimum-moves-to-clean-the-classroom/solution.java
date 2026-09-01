import java.util.ArrayDeque;

/**
 * 3568. Minimum Moves to Clean the Classroom
 * Time: O(m * n * 2^L)
 * Space: O(m * n * 2^L)
 */
class Solution {
    private static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length, n = classroom[0].length();

        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            java.util.Arrays.fill(row, -1);
        }
        int litterCount = 0, sr = 0, sc = 0;
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                char ch = classroom[r].charAt(c);
                if (ch == 'S') {
                    sr = r;
                    sc = c;
                } else if (ch == 'L') {
                    litterId[r][c] = litterCount++;
                }
            }
        }

        int full = (1 << litterCount) - 1;
        if (full == 0) {
            return 0;
        }

        // best[r][c][mask] = highest energy seen there; more energy is never worse.
        int[][][] best = new int[m][n][full + 1];
        for (int[][] plane : best) {
            for (int[] row : plane) {
                java.util.Arrays.fill(row, -1);
            }
        }
        best[sr][sc][0] = energy;

        ArrayDeque<int[]> dq = new ArrayDeque<>();
        dq.add(new int[]{sr, sc, 0, energy});

        int moves = 0;
        while (!dq.isEmpty()) {
            int size = dq.size();
            for (int i = 0; i < size; i++) {
                int[] cur = dq.poll();
                int r = cur[0], c = cur[1], mask = cur[2], e = cur[3];
                if (e == 0) {
                    continue; // cannot move without energy
                }
                for (int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                        continue;
                    }
                    char ch = classroom[nr].charAt(nc);
                    if (ch == 'X') {
                        continue;
                    }

                    int ne = e - 1;
                    int nmask = mask;
                    if (ch == 'L') {
                        nmask |= 1 << litterId[nr][nc];
                    }
                    if (ch == 'R') {
                        ne = energy; // reset area refills to capacity
                    }

                    if (nmask == full) {
                        return moves + 1;
                    }
                    if (ne > best[nr][nc][nmask]) {
                        best[nr][nc][nmask] = ne;
                        dq.add(new int[]{nr, nc, nmask, ne});
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}
