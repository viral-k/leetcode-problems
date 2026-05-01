from typing import List


class Solution:
    def maxRotateFunction(self, nums: List[int]) -> int:
        """
        396. Rotate Function
        Time: O(n)
        Space: O(1)
        """
        n = len(nums)
        total = sum(nums)
        current = sum(i * num for i, num in enumerate(nums))
        best = current

        for k in range(1, n):
            current += total - n * nums[n - k]
            best = max(best, current)

        return best
