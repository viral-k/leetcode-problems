from typing import List


class Solution:
    def shiftGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        """
        1260. Shift 2D Grid
        Time: O(m * n)
        Space: O(m * n)
        """
        m, n = len(grid), len(grid[0])
        total = m * n
        k %= total  # full rotations are no-ops

        result = [[0] * n for _ in range(m)]
        for i in range(m):
            for j in range(n):
                new_idx = (i * n + j + k) % total
                result[new_idx // n][new_idx % n] = grid[i][j]
        return result
