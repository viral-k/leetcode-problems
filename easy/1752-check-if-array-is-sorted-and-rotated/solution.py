from typing import List


class Solution:
    def check(self, nums: List[int]) -> bool:
        """
        1752. Check if Array Is Sorted and Rotated
        Time: O(n)
        Space: O(1)
        """
        drops = 0
        n = len(nums)

        for i in range(n):
            if nums[i] > nums[(i + 1) % n]:
                drops += 1

                if drops > 1:
                    return False

        return True
