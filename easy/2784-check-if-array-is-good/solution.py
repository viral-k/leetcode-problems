from collections import Counter
from typing import List


class Solution:
    def isGood(self, nums: List[int]) -> bool:
        """
        2784. Check if Array is Good
        Time: O(n)
        Space: O(n)
        """
        n = max(nums)

        if len(nums) != n + 1:
            return False

        count = Counter(nums)

        for value in range(1, n):
            if count[value] != 1:
                return False

        return count[n] == 2
