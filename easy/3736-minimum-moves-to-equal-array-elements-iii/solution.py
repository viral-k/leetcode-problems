from typing import List


class Solution:
    def minMoves(self, nums: List[int]) -> int:
        """
        3736. Minimum Moves to Equal Array Elements III
        Time: O(n)
        Space: O(1)
        """
        # Values only go up, so everything rises to the current max.
        return len(nums) * max(nums) - sum(nums)
