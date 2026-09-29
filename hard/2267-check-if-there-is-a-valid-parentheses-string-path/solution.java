/**
 * 2267. Check if There Is a Valid Parentheses String Path
 * Time: O(m * n * (m + n))
 * Space: O(n * (m + n))
 */
class Solution {
    public boolean hasValidPath(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int length = m + n - 1;
        if (length % 2 != 0) {
            return false;
        }

        int maxBal = length;
        // cur[j][b] / prev[j][b] = balance b reachable after consuming that cell
        boolean[][] prev = new boolean[n][maxBal + 1];
        boolean[][] cur = new boolean[n][maxBal + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean[] incoming = new boolean[maxBal + 1];
                if (i == 0 && j == 0) {
                    incoming[0] = true;  // balance 0 before reading anything
                } else {
                    for (int b = 0; b <= maxBal; b++) {
                        incoming[b] = (j > 0 && cur[j - 1][b]) || (i > 0 && prev[j][b]);
                    }
                }

                boolean[] out = new boolean[maxBal + 1];
                if (grid[i][j] == '(') {
                    for (int b = 0; b < maxBal; b++) {
                        if (incoming[b]) {
                            out[b + 1] = true;
                        }
                    }
                } else {
                    // balance 0 with a ')' would go negative, so it is dropped
                    for (int b = 1; b <= maxBal; b++) {
                        if (incoming[b]) {
                            out[b - 1] = true;
                        }
                    }
                }
                cur[j] = out;
            }
            boolean[][] swap = prev;
            prev = cur;
            cur = swap;
        }

        return prev[n - 1][0];
    }
}
