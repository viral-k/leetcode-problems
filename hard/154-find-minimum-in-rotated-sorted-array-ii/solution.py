from typing import List


class Solution:
    def findMin(self, nums: List[int]) -> int:
        """
        154. Find Minimum in Rotated Sorted Array II
        Time: O(log n) average, O(n) worst case
        Space: O(1)
        """
        left = 0
        right = len(nums) - 1

        while left < right:
            mid = (left + right) // 2

            if nums[mid] > nums[right]:
                left = mid + 1
            elif nums[mid] < nums[right]:
                right = mid
            else:
                right -= 1

        return nums[left]
