from typing import List
from functools import lru_cache


class Solution:
    def stoneGameII(self, piles: List[int]) -> int:
        """
        1140. Stone Game II
        Time: O(n^3)
        Space: O(n^2)
        """
        n = len(piles)

        # suffix[i] = sum of piles[i:]
        suffix = [0] * (n + 1)
        for i in range(n - 1, -1, -1):
            suffix[i] = suffix[i + 1] + piles[i]

        @lru_cache(maxsize=None)
        def dp(i: int, M: int) -> int:
            # max stones the current player can take from piles[i:]
            if i >= n:
                return 0
            if 2 * M >= n - i:
                return suffix[i]  # can take everything that remains
            best = 0
            for x in range(1, 2 * M + 1):
                # opponent then plays optimally on the rest
                best = max(best, suffix[i] - dp(i + x, max(M, x)))
            return best

        result = dp(0, 1)
        dp.cache_clear()
        return result
