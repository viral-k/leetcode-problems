from typing import List


class Solution:
    def containsCycle(self, grid: List[List[str]]) -> bool:
        """
        1559. Detect Cycles in 2D Grid
        Time: O(m * n)
        Space: O(m * n)
        """
        m, n = len(grid), len(grid[0])
        visited = [[False] * n for _ in range(m)]

        def dfs(i: int, j: int, pi: int, pj: int, char: str) -> bool:
            visited[i][j] = True

            for di, dj in [(0, 1), (0, -1), (1, 0), (-1, 0)]:
                ni, nj = i + di, j + dj

                if 0 <= ni < m and 0 <= nj < n and grid[ni][nj] == char:
                    if not visited[ni][nj]:
                        if dfs(ni, nj, i, j, char):
                            return True
                    elif (ni, nj) != (pi, pj):
                        return True

            return False

        for i in range(m):
            for j in range(n):
                if not visited[i][j]:
                    if dfs(i, j, -1, -1, grid[i][j]):
                        return True

        return False
