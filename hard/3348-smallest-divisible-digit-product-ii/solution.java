/**
 * 3348. Smallest Divisible Digit Product II
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    // Per-digit (2,3,5,7) exponent contributions, indexed by digit.
    private static final int[][] C = {
        {0, 0, 0, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}, {0, 1, 0, 0}, {2, 0, 0, 0},
        {0, 0, 1, 0}, {1, 1, 0, 0}, {0, 0, 0, 1}, {3, 0, 0, 0}, {0, 2, 0, 0},
    };

    private int A2, A3, A5, A7;

    public String smallestNumber(String num, long t) {
        // Reduce t to its 2/3/5/7 exponents; any leftover prime is impossible.
        int[] e = new int[8];
        for (int p : new int[]{2, 3, 5, 7}) {
            while (t % p == 0) {
                t /= p;
                e[p]++;
            }
        }
        if (t != 1) {
            return "-1";
        }
        A2 = e[2]; A3 = e[3]; A5 = e[5]; A7 = e[7];

        int[] S = buildDigits(A2, A3, A5, A7);
        int minC = S.length;

        int n = num.length();
        int[] digs = new int[n];
        for (int i = 0; i < n; i++) {
            digs[i] = num.charAt(i) - '0';
        }

        // First zero index (kept prefix must be zero-free).
        int z = n;
        for (int i = 0; i < n; i++) {
            if (digs[i] == 0) {
                z = i;
                break;
            }
        }

        // Cumulative exponent contribution of num[0..i-1] (valid for i <= z).
        int[][] pref = new int[n + 1][4];
        for (int i = 0; i < n; i++) {
            pref[i + 1] = pref[i];
            if (i < z) {
                int[] c = C[digs[i]];
                pref[i + 1] = new int[]{pref[i][0] + c[0], pref[i][1] + c[1],
                                        pref[i][2] + c[2], pref[i][3] + c[3]};
            }
        }

        // Candidate: num itself (zero-free and already covers t).
        if (z == n) {
            int[] f = pref[n];
            if (f[0] >= A2 && f[1] >= A3 && f[2] >= A5 && f[3] >= A7) {
                return num;
            }
        }

        // Same length: bump at the largest feasible position.
        int hi = (z < n) ? z : n - 1;
        for (int i = hi; i >= 0; i--) {
            int[] base = pref[i];
            int avail = n - 1 - i;
            for (int d = digs[i] + 1; d <= 9; d++) {
                int[] cd = C[d];
                int r2 = Math.max(0, A2 - (base[0] + cd[0]));
                int r3 = Math.max(0, A3 - (base[1] + cd[1]));
                int r5 = Math.max(0, A5 - (base[2] + cd[2]));
                int r7 = Math.max(0, A7 - (base[3] + cd[3]));
                int need = mincount(r2, r3, r5, r7);
                if (need <= avail) {
                    int[] suf = buildDigits(r2, r3, r5, r7);
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i);
                    sb.append((char) ('0' + d));
                    for (int k = 0; k < avail - need; k++) {
                        sb.append('1');
                    }
                    for (int digit : suf) {
                        sb.append((char) ('0' + digit));
                    }
                    return sb.toString();
                }
            }
        }

        // No same-length answer: use the smallest longer covering number.
        int L = Math.max(n + 1, minC);
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < L - minC; k++) {
            sb.append('1');
        }
        for (int digit : S) {
            sb.append((char) ('0' + digit));
        }
        return sb.toString();
    }

    /** Smallest digits covering r2 twos (0..2) and r3 threes (0..1). */
    private int[] leftover(int r2, int r3) {
        if (r2 == 1 && r3 == 1) return new int[]{6};
        if (r2 == 2 && r3 == 1) return new int[]{2, 6};
        if (r2 == 1 && r3 == 0) return new int[]{2};
        if (r2 == 2 && r3 == 0) return new int[]{4};
        if (r2 == 0 && r3 == 1) return new int[]{3};
        return new int[]{};
    }

    /** Minimal covering multiset, sorted ascending. */
    private int[] buildDigits(int x2, int x3, int x5, int x7) {
        int n9 = x3 / 2, r3 = x3 % 2;
        int n8 = x2 / 3, r2 = x2 % 3;
        int[] lo = leftover(r2, r3);
        int total = n9 + n8 + lo.length + x5 + x7;
        int[] ds = new int[total];
        int p = 0;
        for (int i = 0; i < n9; i++) ds[p++] = 9;
        for (int i = 0; i < n8; i++) ds[p++] = 8;
        for (int v : lo) ds[p++] = v;
        for (int i = 0; i < x5; i++) ds[p++] = 5;
        for (int i = 0; i < x7; i++) ds[p++] = 7;
        java.util.Arrays.sort(ds);
        return ds;
    }

    private int mincount(int x2, int x3, int x5, int x7) {
        int n9 = x3 / 2, r3 = x3 % 2;
        int n8 = x2 / 3, r2 = x2 % 3;
        return n9 + n8 + leftover(r2, r3).length + x5 + x7;
    }
}
