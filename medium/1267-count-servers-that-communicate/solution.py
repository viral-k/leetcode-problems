class Solution:
    def countServers(self, grid: list[list[int]]) -> int:
        """
        1267. Count Servers that Communicate
        Time: O(m * n)
        Space: O(m + n)
        """
        rows = [sum(row) for row in grid]
        cols = [sum(col) for col in zip(*grid)]

        # A server communicates when its row or its column holds another server.
        return sum(
            1
            for i, row in enumerate(grid)
            for j, cell in enumerate(row)
            if cell and (rows[i] > 1 or cols[j] > 1)
        )
