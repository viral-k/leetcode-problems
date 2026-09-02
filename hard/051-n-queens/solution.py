from typing import List


class Solution:
    def solveNQueens(self, n: int) -> List[List[str]]:
        """
        51. N-Queens
        Time: O(n!)
        Space: O(n) excluding the output
        """
        result = []
        placement = [-1] * n          # placement[row] = chosen column
        cols = set()
        diags = set()                 # row - col, constant along "\"
        antis = set()                 # row + col, constant along "/"

        def backtrack(row: int) -> None:
            if row == n:
                result.append([
                    "." * c + "Q" + "." * (n - c - 1) for c in placement
                ])
                return
            for c in range(n):
                if c in cols or (row - c) in diags or (row + c) in antis:
                    continue
                placement[row] = c
                cols.add(c)
                diags.add(row - c)
                antis.add(row + c)

                backtrack(row + 1)

                cols.remove(c)
                diags.remove(row - c)
                antis.remove(row + c)
                placement[row] = -1

        backtrack(0)
        return result
