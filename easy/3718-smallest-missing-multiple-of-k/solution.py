from typing import List


class Solution:
    def smallestMissingMultiple(self, nums: List[int], k: int) -> int:
        """
        3718. Smallest Missing Multiple of K
        Time: O(n)
        Space: O(n)
        """
        present = set(nums)
        m = k
        while m in present:
            m += k
        return m
