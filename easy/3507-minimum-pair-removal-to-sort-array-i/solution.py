from typing import List


class Solution:
    def minimumPairRemoval(self, nums: List[int]) -> int:
        """
        3507. Minimum Pair Removal to Sort Array I
        Time: O(n³)
        Space: O(1)
        """
        ops = 0

        def is_non_decreasing(arr: List[int]) -> bool:
            for i in range(1, len(arr)):
                if arr[i] < arr[i - 1]:
                    return False
            return True

        while not is_non_decreasing(nums):
            min_sum = float('inf')
            idx = 0

            for i in range(len(nums) - 1):
                s = nums[i] + nums[i + 1]
                if s < min_sum:
                    min_sum = s
                    idx = i

            nums[idx] = nums[idx] + nums[idx + 1]
            nums.pop(idx + 1)
            ops += 1

        return ops
