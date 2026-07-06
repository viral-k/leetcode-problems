import java.util.List;

/**
 * 1301. Number of Paths with Max Score
 * Time: O(n^2)
 * Space: O(n^2)
 */
class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int NEG = Integer.MIN_VALUE;

    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int[][] best = new int[n][n];
        long[][] cnt = new long[n][n];
        for (int[] row : best) {
            java.util.Arrays.fill(row, NEG);
        }
        best[n - 1][n - 1] = 0; // start at 'S'
        cnt[n - 1][n - 1] = 1;

        int[][] preds = {{1, 0}, {0, 1}, {1, 1}};
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                char ch = board.get(i).charAt(j);
                if (ch == 'X' || (i == n - 1 && j == n - 1) || ch == 'S') {
                    continue;
                }
                int bmax = NEG;
                for (int[] d : preds) {
                    int pi = i + d[0], pj = j + d[1];
                    if (pi < n && pj < n && best[pi][pj] > bmax) {
                        bmax = best[pi][pj];
                    }
                }
                if (bmax == NEG) {
                    continue; // unreachable
                }
                long ways = 0;
                for (int[] d : preds) {
                    int pi = i + d[0], pj = j + d[1];
                    if (pi < n && pj < n && best[pi][pj] == bmax) {
                        ways = (ways + cnt[pi][pj]) % MOD;
                    }
                }
                int val = (ch == 'E') ? 0 : ch - '0';
                best[i][j] = bmax + val;
                cnt[i][j] = ways;
            }
        }

        if (best[0][0] == NEG) {
            return new int[]{0, 0};
        }
        return new int[]{best[0][0], (int) (cnt[0][0] % MOD)};
    }
}
