from typing import List


class Solution:
    def rotateGrid(self, grid: List[List[int]], k: int) -> List[List[int]]:
        """
        1914. Cyclically Rotating a Grid
        Time: O(m × n)
        Space: O(m + n)
        """
        m, n = len(grid), len(grid[0])
        layers = min(m, n) // 2

        for layer in range(layers):
            coords = self._layer_coordinates(m, n, layer)
            values = [grid[row][col] for row, col in coords]
            shift = k % len(values)

            for i, (row, col) in enumerate(coords):
                grid[row][col] = values[(i - shift) % len(values)]

        return grid

    def _layer_coordinates(self, m: int, n: int, layer: int) -> List[tuple[int, int]]:
        top = layer
        bottom = m - 1 - layer
        left = layer
        right = n - 1 - layer
        coords = []

        for row in range(top, bottom + 1):
            coords.append((row, left))

        for col in range(left + 1, right + 1):
            coords.append((bottom, col))

        for row in range(bottom - 1, top - 1, -1):
            coords.append((row, right))

        for col in range(right - 1, left, -1):
            coords.append((top, col))

        return coords
