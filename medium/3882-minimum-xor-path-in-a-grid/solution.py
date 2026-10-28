class Solution:
    def minCost(self, grid: list[list[int]]) -> int:
        """
        3882. Minimum XOR Path in a Grid
        Time: O(m * n * V), V = 1024
        Space: O(n * V)
        """
        m, n = len(grid), len(grid[0])

        # prev[c] = every XOR value a path can have on arriving at (r - 1, c).
        # Values fit in 10 bits, so no set ever holds more than 1024 numbers.
        prev = []
        for r in range(m):
            cur = []
            for c in range(n):
                if r == 0 and c == 0:
                    incoming = {0}
                elif r == 0:
                    incoming = cur[c - 1]
                elif c == 0:
                    incoming = prev[c]
                else:
                    incoming = prev[c] | cur[c - 1]
                v = grid[r][c]
                cur.append({x ^ v for x in incoming})
            prev = cur

        return min(prev[-1])
