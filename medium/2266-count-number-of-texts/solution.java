/**
 * 2266. Count Number of Texts
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int countTexts(String pressedKeys) {
        int n = pressedKeys.length();

        // dp3: tile length i with pieces 1..3; dp4: pieces 1..4.
        long[] dp3 = new long[n + 1];
        long[] dp4 = new long[n + 1];
        dp3[0] = dp4[0] = 1;
        for (int i = 1; i <= n; i++) {
            dp3[i] = dp3[i - 1];
            if (i >= 2) dp3[i] += dp3[i - 2];
            if (i >= 3) dp3[i] += dp3[i - 3];
            dp3[i] %= MOD;

            dp4[i] = dp4[i - 1];
            if (i >= 2) dp4[i] += dp4[i - 2];
            if (i >= 3) dp4[i] += dp4[i - 3];
            if (i >= 4) dp4[i] += dp4[i - 4];
            dp4[i] %= MOD;
        }

        long ans = 1;
        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && pressedKeys.charAt(j) == pressedKeys.charAt(i)) {
                j++;
            }
            int run = j - i;
            char c = pressedKeys.charAt(i);
            long[] table = (c == '7' || c == '9') ? dp4 : dp3;
            ans = ans * table[run] % MOD;
            i = j;
        }
        return (int) ans;
    }
}
