class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        """
        10. Regular Expression Matching
        Time: O(m * n)
        Space: O(m * n)
        """
        m, n = len(s), len(p)

        # dp[i][j] = does s[i:] match p[j:]
        dp = [[False] * (n + 1) for _ in range(m + 1)]
        dp[m][n] = True  # both exhausted

        for i in range(m, -1, -1):
            for j in range(n - 1, -1, -1):
                first = i < m and p[j] in (s[i], ".")
                if j + 1 < n and p[j + 1] == "*":
                    # skip the x* group entirely, or consume one char and keep it
                    dp[i][j] = dp[i][j + 2] or (first and dp[i + 1][j])
                else:
                    dp[i][j] = first and dp[i + 1][j + 1]

        return dp[0][0]
