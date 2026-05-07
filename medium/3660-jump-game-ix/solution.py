from typing import List


class Solution:
    def maxValue(self, nums: List[int]) -> List[int]:
        """
        3660. Jump Game IX
        Time: O(n)
        Space: O(n)
        """
        n = len(nums)
        suffix_min = nums[:]

        for i in range(n - 2, -1, -1):
            suffix_min[i] = min(nums[i], suffix_min[i + 1])

        ans = [0] * n
        start = 0
        component_max = nums[0]

        for i, num in enumerate(nums):
            component_max = max(component_max, num)

            if i == n - 1 or component_max <= suffix_min[i + 1]:
                for j in range(start, i + 1):
                    ans[j] = component_max

                if i + 1 < n:
                    start = i + 1
                    component_max = nums[start]

        return ans
