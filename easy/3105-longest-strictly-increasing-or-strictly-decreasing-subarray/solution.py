from typing import List


class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        """
        3105. Longest Strictly Increasing or Strictly Decreasing Subarray
        Time: O(n)
        Space: O(1)
        """
        # inc / dec = length of the strictly increasing / decreasing run ending here.
        inc = dec = best = 1
        for prev, cur in zip(nums, nums[1:]):
            if cur > prev:
                inc, dec = inc + 1, 1
            elif cur < prev:
                inc, dec = 1, dec + 1
            else:
                inc = dec = 1
            best = max(best, inc, dec)
        return best
