from typing import List


class Solution:
    def minOperations(self, nums: List[int], x: int) -> int:
        """
        1658. Minimum Operations to Reduce X to Zero
        Time: O(n)
        Space: O(1)
        """
        n = len(nums)
        target = sum(nums) - x
        if target < 0:
            return -1

        # fewest removals == longest middle subarray summing to target
        best = -1
        window = 0
        left = 0
        if target == 0:
            best = 0

        for right in range(n):
            window += nums[right]
            while window > target:
                window -= nums[left]
                left += 1
            if window == target:
                best = max(best, right - left + 1)

        return -1 if best < 0 else n - best
