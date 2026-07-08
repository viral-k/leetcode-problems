/**
 * 3756. Concatenate Non-Zero Digits and Multiply by Sum II
 * Time: O(m + q)
 * Space: O(m)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int[] concatenateAndMultiply(String s, int[][] queries) {
        int m = s.length();

        // Powers of 10 and inverse powers of 10, indexed by non-zero-digit count.
        long[] pow10 = new long[m + 1];
        long[] inv10pow = new long[m + 1];
        pow10[0] = 1;
        for (int i = 1; i <= m; i++) {
            pow10[i] = pow10[i - 1] * 10 % MOD;
        }
        long inv10 = modpow(10, MOD - 2);
        inv10pow[0] = 1;
        for (int i = 1; i <= m; i++) {
            inv10pow[i] = inv10pow[i - 1] * inv10 % MOD;
        }

        // Prefix arrays.
        int[] cnt = new int[m + 1];       // non-zero-digit count in s[0..i-1]
        long[] sumPref = new long[m + 1]; // digit-value sum in s[0..i-1]
        long[] wPref = new long[m + 1];   // sum of weights w_q for q < i
        for (int i = 0; i < m; i++) {
            int d = s.charAt(i) - '0';
            cnt[i + 1] = cnt[i] + (d != 0 ? 1 : 0);
            sumPref[i + 1] = sumPref[i] + d;
            long w = (d != 0) ? d * inv10pow[cnt[i + 1]] % MOD : 0;
            wPref[i + 1] = (wPref[i] + w) % MOD;
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0], r = queries[i][1];
            long S = (wPref[r + 1] - wPref[l] + MOD) % MOD;
            long x = pow10[cnt[r + 1]] * S % MOD;
            long total = (sumPref[r + 1] - sumPref[l]) % MOD;
            ans[i] = (int) (x * total % MOD);
        }
        return ans;
    }

    private long modpow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return result;
    }
}
