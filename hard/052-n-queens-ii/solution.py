class Solution:
    def totalNQueens(self, n: int) -> int:
        """
        52. N-Queens II
        Time: O(n!)
        Space: O(n)
        """
        full = (1 << n) - 1

        def backtrack(cols: int, diag: int, anti: int) -> int:
            if cols == full:
                return 1  # every row placed
            count = 0
            avail = ~(cols | diag | anti) & full
            while avail:
                p = avail & -avail       # lowest available column
                avail -= p
                # diagonals shift by one column as we descend a row
                count += backtrack(cols | p, ((diag | p) << 1) & full, (anti | p) >> 1)
            return count

        return backtrack(0, 0, 0)
