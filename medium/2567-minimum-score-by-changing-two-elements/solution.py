from heapq import nlargest, nsmallest
from typing import List


class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        """
        2567. Minimum Score by Changing Two Elements
        Time: O(n)
        Space: O(1)
        """
        # Changed elements copy a value still in the array, so the low score is
        # 0 and the answer is the smallest range left after dropping two
        # extremes. Only the 3 smallest and 3 largest values matter.
        a0, a1, a2 = nsmallest(3, nums)  # ascending
        b0, b1, b2 = nlargest(3, nums)  # descending
        return min(
            b0 - a2,  # drop the two smallest
            b2 - a0,  # drop the two largest
            b1 - a1,  # drop one of each
        )
