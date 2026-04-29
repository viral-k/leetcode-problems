from typing import List


class Solution:
    def maximumScore(self, grid: List[List[int]]) -> int:
        """
        3225. Maximum Score From Grid Operations
        Time: O(n^3)
        Space: O(n^2)
        """
        n = len(grid)

        # Precompute prefix sums for each column
        psum = [[0] * (n + 1) for _ in range(n)]
        for j in range(n):
            for i in range(n):
                psum[j][i + 1] = psum[j][i] + grid[i][j]

        NEG_INF = float("-inf")

        # dp[a][b] = max score, h[prev_col] = a, h[curr_col] = b
        dp = [[NEG_INF] * (n + 1) for _ in range(n + 1)]
        for b in range(n + 1):
            dp[0][b] = 0  # h[-1] = 0

        for j in range(n - 1):
            # suffix[a][b] = max over k >= a of (dp[k][b] + psum[j][k])
            suffix = [[NEG_INF] * (n + 1) for _ in range(n + 2)]
            # prefix[a][b] = max over k < a of dp[k][b]
            prefix = [[NEG_INF] * (n + 1) for _ in range(n + 2)]

            for b in range(n + 1):
                for a in range(n, -1, -1):
                    suffix[a][b] = max(dp[a][b] + psum[j][a], suffix[a + 1][b])

                for a in range(1, n + 2):
                    prev_dp = dp[a - 1][b] if a - 1 <= n else NEG_INF
                    prefix[a][b] = max(prefix[a - 1][b], prev_dp)

            new_dp = [[NEG_INF] * (n + 1) for _ in range(n + 1)]

            for b in range(n + 1):
                # Case: c <= b (contribution only from a > b)
                val = max(suffix[b + 1][b] - psum[j][b], prefix[b + 1][b])
                for c in range(b + 1):
                    new_dp[b][c] = val

                # Case: c > b
                for c in range(b + 1, n + 1):
                    val = max(suffix[c][b], prefix[c][b] + psum[j][c]) - psum[j][b]
                    new_dp[b][c] = val

            dp = new_dp

        # Final: add column n-1's contribution (h[n] = 0)
        ans = 0
        for a in range(n + 1):
            for b in range(n + 1):
                if dp[a][b] == NEG_INF:
                    continue
                contrib = psum[n - 1][a] - psum[n - 1][b] if a > b else 0
                ans = max(ans, dp[a][b] + contrib)

        return ans
