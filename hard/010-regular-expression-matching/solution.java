/**
 * 10. Regular Expression Matching
 * Time: O(m * n)
 * Space: O(m * n)
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();

        // dp[i][j] = does s[i:] match p[j:]
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[m][n] = true; // both exhausted

        for (int i = m; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                boolean first = i < m
                    && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '.');
                if (j + 1 < n && p.charAt(j + 1) == '*') {
                    // skip the x* group entirely, or consume one char and keep it
                    dp[i][j] = dp[i][j + 2] || (first && dp[i + 1][j]);
                } else {
                    dp[i][j] = first && dp[i + 1][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
