from typing import List


class Solution:
    def maxPathScore(self, grid: List[List[int]], k: int) -> int:
        """
        3742. Maximum Path Score in a Grid
        Time:  O(m * n * min(k, m + n - 1))
        Space: O(n * min(k, m + n - 1))  -- rolling rows
        """
        m, n = len(grid), len(grid[0])
        K = min(k, m + n - 1)
        NEG = float("-inf")

        prev = [[NEG] * (K + 1) for _ in range(n)]
        prev[0][0] = 0  # grid[0][0] == 0 by constraint

        for j in range(1, n):
            val = grid[0][j]
            cost = 0 if val == 0 else 1
            row_prev = prev[j - 1]
            row_curr = prev[j]
            for c in range(cost, K + 1):
                left = row_prev[c - cost]
                if left != NEG:
                    row_curr[c] = left + val

        for i in range(1, m):
            curr = [[NEG] * (K + 1) for _ in range(n)]

            val0 = grid[i][0]
            cost0 = 0 if val0 == 0 else 1
            top0 = prev[0]
            cur0 = curr[0]
            for c in range(cost0, K + 1):
                top_val = top0[c - cost0]
                if top_val != NEG:
                    cur0[c] = top_val + val0

            for j in range(1, n):
                val = grid[i][j]
                cost = 0 if val == 0 else 1
                top = prev[j]
                left = curr[j - 1]
                cur = curr[j]
                for c in range(cost, K + 1):
                    t = top[c - cost]
                    l = left[c - cost]
                    best = t if t > l else l
                    if best != NEG:
                        cur[c] = best + val

            prev = curr

        ans = max(prev[n - 1])
        return int(ans) if ans != NEG else -1
