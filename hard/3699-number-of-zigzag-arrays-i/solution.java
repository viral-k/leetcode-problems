/**
 * 3699. Number of ZigZag Arrays I
 * Time: O(n * m) where m = r - l + 1
 * Space: O(m)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        // up[v]/down[v]: sequences ending at value v with last step up/down.
        long[] up = new long[m];
        long[] down = new long[m];
        for (int v = 0; v < m; v++) {
            up[v] = 1;
            down[v] = 1;
        }

        for (int step = 2; step <= n; step++) {
            long[] newUp = new long[m];
            long[] newDown = new long[m];

            long prefix = 0; // sum of down[u] for u < v
            for (int v = 0; v < m; v++) {
                newUp[v] = prefix;
                prefix = (prefix + down[v]) % MOD;
            }

            long suffix = 0; // sum of up[u] for u > v
            for (int v = m - 1; v >= 0; v--) {
                newDown[v] = suffix;
                suffix = (suffix + up[v]) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long answer = 0;
        for (int v = 0; v < m; v++) {
            answer = (answer + up[v] + down[v]) % MOD;
        }
        return (int) answer;
    }
}
