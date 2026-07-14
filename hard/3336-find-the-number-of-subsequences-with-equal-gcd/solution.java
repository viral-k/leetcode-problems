/**
 * 3336. Find the Number of Subsequences With Equal GCD
 * Time: O(n * V^2)
 * Space: O(V^2)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int subsequencePairCount(int[] nums) {
        int V = 0;
        for (int x : nums) {
            V = Math.max(V, x);
        }

        // dp[g1][g2]: ways so far; 0 means "empty" (gcd(0, x) = x).
        long[][] dp = new long[V + 1][V + 1];
        dp[0][0] = 1;

        for (int num : nums) {
            long[][] nxt = new long[V + 1][V + 1];
            for (int g1 = 0; g1 <= V; g1++) {
                for (int g2 = 0; g2 <= V; g2++) {
                    nxt[g1][g2] = dp[g1][g2]; // "skip" choice
                }
            }
            for (int g1 = 0; g1 <= V; g1++) {
                for (int g2 = 0; g2 <= V; g2++) {
                    long c = dp[g1][g2];
                    if (c == 0) {
                        continue;
                    }
                    int ng1 = gcd(g1, num); // gcd(0, num) == num
                    int ng2 = gcd(g2, num);
                    nxt[ng1][g2] = (nxt[ng1][g2] + c) % MOD; // add to seq1
                    nxt[g1][ng2] = (nxt[g1][ng2] + c) % MOD; // add to seq2
                }
            }
            dp = nxt;
        }

        long ans = 0;
        for (int g = 1; g <= V; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
