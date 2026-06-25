from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], target: int) -> int:
        """
        3737. Count Subarrays With Majority Element I
        Time: O(n^2)
        Space: O(1)
        """
        n = len(nums)
        ans = 0
        for i in range(n):
            count = 0
            for j in range(i, n):
                if nums[j] == target:
                    count += 1
                if count * 2 > j - i + 1:
                    ans += 1
        return ans
