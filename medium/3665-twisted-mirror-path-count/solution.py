from typing import List


class Solution:
    def uniquePaths(self, grid: List[List[int]]) -> int:
        """
        3665. Twisted Mirror Path Count
        Time: O(m * n)
        Space: O(n)
        """
        MOD = 10**9 + 7
        m, n = len(grid), len(grid[0])

        # down[j] = ways to enter (i, j) moving down, filled by the row above.
        down = [0] * n
        for i in range(m):
            row = grid[i]
            nxt = [0] * n
            # right = ways to enter (i, j) moving right, from (i, j - 1).
            right = 0
            for j in range(n):
                r, d = right, down[j]
                if i == 0 and j == 0:
                    r, d = 1, 0
                if row[j]:
                    # Mirror: moving right turns down, moving down turns right.
                    nxt[j] = r
                    right = d
                else:
                    t = (r + d) % MOD
                    nxt[j] = t
                    right = t
                if i == m - 1 and j == n - 1:
                    return (r + d) % MOD
            # right leaving column n - 1 and nxt leaving row m - 1 fall off the grid.
            down = nxt

        return 0
