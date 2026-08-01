from typing import List


class Solution:
    def predictTheWinner(self, nums: List[int]) -> bool:
        """
        486. Predict the Winner
        Time: O(n^2)
        Space: O(n)
        """
        n = len(nums)
        # dp[j] holds dp[i][j] for the current i, rolling i from high to low.
        dp = nums[:]  # base case: dp[i][i] = nums[i]
        for i in range(n - 2, -1, -1):
            for j in range(i + 1, n):
                dp[j] = max(nums[i] - dp[j], nums[j] - dp[j - 1])
        return dp[n - 1] >= 0
