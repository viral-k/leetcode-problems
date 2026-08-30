from typing import List


class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        """
        2091. Removing Minimum and Maximum From Array
        Time: O(n)
        Space: O(1)
        """
        n = len(nums)
        min_idx = min(range(n), key=lambda i: nums[i])
        max_idx = max(range(n), key=lambda i: nums[i])
        lo, hi = min(min_idx, max_idx), max(min_idx, max_idx)

        both_front = hi + 1
        both_back = n - lo
        split = (lo + 1) + (n - hi)
        return min(both_front, both_back, split)
