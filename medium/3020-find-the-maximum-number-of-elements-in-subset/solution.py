from typing import List
from collections import Counter


class Solution:
    def maximumLength(self, nums: List[int]) -> int:
        """
        3020. Find the Maximum Number of Elements in Subset
        Time: O(n)
        Space: O(n)
        """
        freq = Counter(nums)
        ans = 1

        # Base 1 is special: 1^2 = 1, so the chain is all ones; length must be odd.
        if 1 in freq:
            ones = freq[1]
            ans = max(ans, ones if ones % 2 == 1 else ones - 1)

        for x in freq:
            if x == 1:
                continue
            count = 0
            cur = x
            while freq.get(cur, 0) >= 2:
                count += 2
                cur *= cur
            # cur now has < 2 copies: use one as the peak, else drop a level.
            count += 1 if freq.get(cur, 0) >= 1 else -1
            ans = max(ans, count)

        return ans
