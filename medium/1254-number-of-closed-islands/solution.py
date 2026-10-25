class Solution:
    def closedIsland(self, grid: list[list[int]]) -> int:
        """
        1254. Number of Closed Islands
        Time: O(m * n)
        Space: O(m * n)
        """
        m, n = len(grid), len(grid[0])
        count = 0

        for sr in range(m):
            for sc in range(n):
                if grid[sr][sc] != 0:
                    continue

                # flood the whole island even after it touches the border,
                # otherwise its leftover cells get counted as a new island
                closed = True
                grid[sr][sc] = 1
                stack = [(sr, sc)]
                while stack:
                    r, c = stack.pop()
                    if r == 0 or c == 0 or r == m - 1 or c == n - 1:
                        closed = False
                    for nr, nc in ((r + 1, c), (r - 1, c), (r, c + 1), (r, c - 1)):
                        if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 0:
                            grid[nr][nc] = 1
                            stack.append((nr, nc))

                if closed:
                    count += 1

        return count
