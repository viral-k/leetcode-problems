from typing import List


class Solution:
    def hasValidPath(self, grid: List[List[str]]) -> bool:
        """
        2267. Check if There Is a Valid Parentheses String Path
        Time: O(m * n * (m + n) / 64) with bitmask balances
        Space: O(m * n)
        """
        m, n = len(grid), len(grid[0])
        length = m + n - 1
        if length % 2:
            return False

        mask = (1 << (length + 1)) - 1
        # dp[i][j] = bitmask of balances reachable after consuming grid[i][j]
        dp = [[0] * n for _ in range(m)]

        for i in range(m):
            row = dp[i]
            prev = dp[i - 1] if i else None
            for j in range(n):
                if i == 0 and j == 0:
                    reach = 1  # balance 0 before reading anything
                else:
                    reach = row[j - 1] if j else 0
                    if prev is not None:
                        reach |= prev[j]
                    if reach == 0:
                        continue

                if grid[i][j] == "(":
                    row[j] = (reach << 1) & mask
                else:
                    # bit 0 falling off is the path whose balance goes negative
                    row[j] = reach >> 1

        return dp[m - 1][n - 1] & 1 == 1
