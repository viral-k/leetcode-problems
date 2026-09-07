/**
 * 115. Distinct Subsequences
 * Time: O(m * n)
 * Space: O(n)
 */
class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length(), n = t.length();
        if (n > m) {
            return 0;
        }

        // dp[j] = ways to form t[:j] from the prefix of s processed so far
        long[] dp = new long[n + 1];
        dp[0] = 1; // the empty target is matched exactly one way

        for (int i = 1; i <= m; i++) {
            char sc = s.charAt(i - 1);
            // descend so dp[j - 1] still holds the previous row's value
            for (int j = n; j >= 1; j--) {
                if (sc == t.charAt(j - 1)) {
                    dp[j] += dp[j - 1];
                }
            }
        }

        return (int) dp[n];
    }
}
