from typing import List
from collections import deque


class Solution:
    def hasValidPath(self, grid: List[List[int]]) -> bool:
        """
        1391. Check if There is a Valid Path in a Grid
        Time: O(m * n)
        Space: O(m * n)
        """
        m, n = len(grid), len(grid[0])

        if m == 1 and n == 1:
            return True

        # Directions: 0=up, 1=right, 2=down, 3=left
        directions = [(-1, 0), (0, 1), (1, 0), (0, -1)]
        opposite = {0: 2, 1: 3, 2: 0, 3: 1}

        # Which directions each street connects
        connections = {
            1: {1, 3},  # left, right
            2: {0, 2},  # up, down
            3: {2, 3},  # down, left
            4: {1, 2},  # right, down
            5: {0, 3},  # up, left
            6: {0, 1},  # up, right
        }

        visited = [[False] * n for _ in range(m)]
        queue = deque([(0, 0)])
        visited[0][0] = True

        while queue:
            i, j = queue.popleft()

            if i == m - 1 and j == n - 1:
                return True

            for d, (di, dj) in enumerate(directions):
                # Check if current cell connects in this direction
                if d not in connections[grid[i][j]]:
                    continue

                ni, nj = i + di, j + dj

                if 0 <= ni < m and 0 <= nj < n and not visited[ni][nj]:
                    # Check if neighbor connects back
                    if opposite[d] in connections[grid[ni][nj]]:
                        visited[ni][nj] = True
                        queue.append((ni, nj))

        return False
