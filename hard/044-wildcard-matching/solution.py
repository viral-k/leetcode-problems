class Solution:
    def isMatch(self, s: str, p: str) -> bool:
        """
        44. Wildcard Matching
        Time: O(m * n)
        Space: O(n)
        """
        m, n = len(s), len(p)

        # dp[j] = does s[:i] match p[:j], rolled forward one row of i at a time.
        dp = [False] * (n + 1)
        dp[0] = True
        for j in range(1, n + 1):
            # only a leading run of '*' can match the empty string
            dp[j] = dp[j - 1] and p[j - 1] == "*"

        for i in range(1, m + 1):
            nxt = [False] * (n + 1)
            nxt[0] = False  # non-empty s can never match an empty pattern
            for j in range(1, n + 1):
                if p[j - 1] == "*":
                    # '*' absorbs s[i-1], or matches the empty sequence
                    nxt[j] = dp[j] or nxt[j - 1]
                else:
                    nxt[j] = dp[j - 1] and (p[j - 1] == "?" or p[j - 1] == s[i - 1])
            dp = nxt

        return dp[n]
