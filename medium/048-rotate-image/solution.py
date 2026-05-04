from typing import List


class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        """
        48. Rotate Image
        Time: O(n²)
        Space: O(1)
        """
        n = len(matrix)

        for row in range(n):
            for col in range(row + 1, n):
                matrix[row][col], matrix[col][row] = matrix[col][row], matrix[row][col]

        for row in matrix:
            row.reverse()
