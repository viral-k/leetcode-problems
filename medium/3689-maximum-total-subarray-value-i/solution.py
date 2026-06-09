from typing import List


class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        """
        3689. Maximum Total Subarray Value I
        Time: O(n)
        Space: O(1)
        """
        return k * (max(nums) - min(nums))
