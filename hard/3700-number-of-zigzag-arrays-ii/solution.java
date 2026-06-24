/**
 * 3700. Number of ZigZag Arrays II
 * Time: O(m^3 log n) where m = r - l + 1
 * Space: O(m^2)
 */
class Solution {
    private static final int MOD = 1_000_000_007;
    private int m;

    public int zigZagArrays(int n, int l, int r) {
        m = r - l + 1;

        // Transition matrix: new_up[v] = sum_{w >= m - v} up[w].
        long[][] base = new long[m][m];
        for (int v = 0; v < m; v++) {
            for (int w = 0; w < m; w++) {
                base[v][w] = (w >= m - v) ? 1 : 0;
            }
        }

        // Binary exponentiation of base to the (n - 1) power.
        long[][] result = identity();
        long power = (long) n - 1;
        while (power > 0) {
            if ((power & 1) == 1) {
                result = mul(result, base);
            }
            base = mul(base, base);
            power >>= 1;
        }

        // Sum of all entries = total over v of up[v]; answer is double that.
        long total = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                total = (total + result[i][j]) % MOD;
            }
        }
        return (int) (2 * total % MOD);
    }

    private long[][] identity() {
        long[][] id = new long[m][m];
        for (int i = 0; i < m; i++) {
            id[i][i] = 1;
        }
        return id;
    }

    private long[][] mul(long[][] a, long[][] b) {
        long[][] c = new long[m][m];
        for (int i = 0; i < m; i++) {
            for (int k = 0; k < m; k++) {
                if (a[i][k] == 0) {
                    continue;
                }
                long aik = a[i][k];
                long[] bk = b[k];
                long[] ci = c[i];
                for (int j = 0; j < m; j++) {
                    ci[j] = (ci[j] + aik * bk[j]) % MOD;
                }
            }
        }
        return c;
    }
}
