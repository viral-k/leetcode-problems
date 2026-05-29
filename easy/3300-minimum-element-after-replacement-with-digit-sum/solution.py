from typing import List


class Solution:
    def minElement(self, nums: List[int]) -> int:
        """
        3300. Minimum Element After Replacement With Digit Sum
        Time: O(n * D)
        Space: O(1)
        """
        def digit_sum(num: int) -> int:
            total = 0
            while num > 0:
                total += num % 10
                num //= 10
            return total

        return min(digit_sum(num) for num in nums)
