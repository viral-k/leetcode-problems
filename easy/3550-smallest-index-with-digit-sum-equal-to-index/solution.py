from typing import List


class Solution:
    def smallestIndex(self, nums: List[int]) -> int:
        """
        3550. Smallest Index With Digit Sum Equal to Index
        Time: O(n * d)
        Space: O(1)
        """
        for i, v in enumerate(nums):
            digit_sum = 0
            while v > 0:
                digit_sum += v % 10
                v //= 10
            if digit_sum == i:
                return i
        return -1
