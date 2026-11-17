class Solution:
    def minimumChanges(self, s: str, k: int) -> int:
        """
        2911. Minimum Changes to Make K Semi-palindromes
        Time: O(n^2 log n + k * n^2)
        Space: O(n^2)
        """
        n = len(s)
        INF = float("inf")

        # cost[i][j] = fewest changes to make s[i..j] a semi-palindrome.
        # Length-1 substrings have no valid divisor and stay INF.
        cost = [[INF] * n for _ in range(n)]
        for d in range(1, n // 2 + 1):
            # g[a][b] = changes to make s[a], s[a+d], ..., s[b] a palindrome
            # (b - a a multiple of d). Peel the outer pair off the inner one.
            g = [[0] * n for _ in range(n)]
            for t in range(1, (n - 1) // d + 1):
                for a in range(n - t * d):
                    b = a + t * d
                    inner = g[a + d][b - d] if t >= 2 else 0
                    g[a][b] = inner + (s[a] != s[b])
            # Substrings whose length is a multiple of d, at least 2 * d, so
            # d is a proper divisor. Group r runs from i + r to j - d + 1 + r.
            for length in range(2 * d, n + 1, d):
                for i in range(n - length + 1):
                    j = i + length - 1
                    c = sum(g[i + r][j - d + 1 + r] for r in range(d))
                    if c < cost[i][j]:
                        cost[i][j] = c

        # dp[j] = best way to split s[:j] into p pieces, each of length >= 2.
        dp = [INF] * (n + 1)
        for j in range(2, n + 1):
            dp[j] = cost[0][j - 1]
        for p in range(2, k + 1):
            new = [INF] * (n + 1)
            for j in range(2 * p, n + 1):
                # the last piece is s[i:j]; the first p - 1 pieces need 2(p - 1) chars
                new[j] = min(dp[i] + cost[i][j - 1] for i in range(2 * (p - 1), j - 1))
            dp = new
        return dp[n]
