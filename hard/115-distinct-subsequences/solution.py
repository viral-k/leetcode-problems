class Solution:
    def numDistinct(self, s: str, t: str) -> int:
        """
        115. Distinct Subsequences
        Time: O(m * n)
        Space: O(n)
        """
        m, n = len(s), len(t)
        if n > m:
            return 0

        # dp[j] = ways to form t[:j] from the prefix of s processed so far
        dp = [0] * (n + 1)
        dp[0] = 1  # the empty target is matched exactly one way

        for i in range(1, m + 1):
            # descend so dp[j - 1] still holds the previous row's value
            for j in range(n, 0, -1):
                if s[i - 1] == t[j - 1]:
                    dp[j] += dp[j - 1]

        return dp[n]
