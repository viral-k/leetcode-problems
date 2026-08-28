/**
 * 44. Wildcard Matching
 * Time: O(m * n)
 * Space: O(n)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // dp[j] = does s[:i] match p[:j], rolled forward one row of i at a time.
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int j = 1; j <= n; j++) {
            // only a leading run of '*' can match the empty string
            dp[j] = dp[j - 1] && p.charAt(j - 1) == '*';
        }

        for (int i = 1; i <= m; i++) {
            boolean[] next = new boolean[n + 1];
            next[0] = false; // non-empty s can never match an empty pattern
            for (int j = 1; j <= n; j++) {
                char pc = p.charAt(j - 1);
                if (pc == '*') {
                    // '*' absorbs s[i-1], or matches the empty sequence
                    next[j] = dp[j] || next[j - 1];
                } else {
                    next[j] = dp[j - 1] && (pc == '?' || pc == s.charAt(i - 1));
                }
            }
            dp = next;
        }

        return dp[n];
    }
}
