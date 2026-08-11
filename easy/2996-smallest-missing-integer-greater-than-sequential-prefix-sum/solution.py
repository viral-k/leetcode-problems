from typing import List


class Solution:
    def missingInteger(self, nums: List[int]) -> int:
        """
        2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
        Time: O(n + A)
        Space: O(n)
        """
        # Longest sequential prefix (must start at index 0).
        total = nums[0]
        for j in range(1, len(nums)):
            if nums[j] != nums[j - 1] + 1:
                break
            total += nums[j]

        present = set(nums)
        x = total
        while x in present:
            x += 1
        return x
