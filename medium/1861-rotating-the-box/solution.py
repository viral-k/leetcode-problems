from typing import List


class Solution:
    def rotateTheBox(self, boxGrid: List[List[str]]) -> List[List[str]]:
        """
        1861. Rotating the Box
        Time: O(m × n)
        Space: O(m × n)
        """
        m, n = len(boxGrid), len(boxGrid[0])

        for row in range(m):
            empty = n - 1

            for col in range(n - 1, -1, -1):
                if boxGrid[row][col] == "*":
                    empty = col - 1
                elif boxGrid[row][col] == "#":
                    boxGrid[row][col] = "."
                    boxGrid[row][empty] = "#"
                    empty -= 1

        rotated = [["."] * m for _ in range(n)]

        for row in range(m):
            for col in range(n):
                rotated[col][m - 1 - row] = boxGrid[row][col]

        return rotated
