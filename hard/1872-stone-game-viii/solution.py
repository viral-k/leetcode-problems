from typing import List
from itertools import accumulate


class Solution:
    def stoneGameVIII(self, stones: List[int]) -> int:
        """
        1872. Stone Game VIII
        Time: O(n)
        Space: O(n)
        """
        n = len(stones)
        prefix = list(accumulate(stones))

        # dp = best difference for the player to move, picks allowed from i onward.
        # At the last index the player must take everything remaining.
        dp = prefix[n - 1]
        for i in range(n - 2, 0, -1):
            # stop here and bank prefix[i], or pass the same options forward
            dp = max(prefix[i] - dp, dp)
        return dp
