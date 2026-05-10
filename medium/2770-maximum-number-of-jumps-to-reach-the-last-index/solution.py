from typing import List


class Solution:
    def maximumJumps(self, nums: List[int], target: int) -> int:
        """
        2770. Maximum Number of Jumps to Reach the Last Index
        Time: O(n²)
        Space: O(n)
        """
        n = len(nums)
        dp = [-1] * n
        dp[0] = 0

        for i in range(n):
            if dp[i] == -1:
                continue

            for j in range(i + 1, n):
                if abs(nums[j] - nums[i]) <= target:
                    dp[j] = max(dp[j], dp[i] + 1)

        return dp[-1]
