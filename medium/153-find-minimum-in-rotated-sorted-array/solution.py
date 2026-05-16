from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        """
        153. Find Minimum in Rotated Sorted Array
        Time: O(log n)
        Space: O(1)
        """
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if nums[mid] > nums[right]:
                left = mid + 1
            else:
                right = mid

        return nums[left]
