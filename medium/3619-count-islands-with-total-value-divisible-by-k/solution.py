from typing import List


class Solution:
    def countIslands(self, grid: List[List[int]], k: int) -> int:
        """
        3619. Count Islands With Total Value Divisible by K
        Time: O(m * n)
        Space: O(m * n)
        """
        m, n = len(grid), len(grid[0])
        count = 0

        for sr in range(m):
            for sc in range(n):
                if grid[sr][sc] == 0:
                    continue

                # keep the total mod k; divisibility only needs the remainder
                remainder = grid[sr][sc] % k
                grid[sr][sc] = 0
                stack = [(sr, sc)]
                while stack:
                    r, c = stack.pop()
                    for nr, nc in ((r + 1, c), (r - 1, c), (r, c + 1), (r, c - 1)):
                        if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] > 0:
                            remainder = (remainder + grid[nr][nc]) % k
                            grid[nr][nc] = 0
                            stack.append((nr, nc))

                if remainder == 0:
                    count += 1

        return count
