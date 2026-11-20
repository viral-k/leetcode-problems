from typing import List


class Solution:
    def maxSelectedElements(self, nums: List[int]) -> int:
        """
        3041. Maximize Consecutive Elements in an Array After Modification
        Time: O(n log n)
        Space: O(n)
        """
        # dp[v] = longest run of consecutive values ending exactly at v.
        dp = {}
        best = 0
        for x in sorted(nums):
            # Use x as x + 1 first: it needs dp[x] from before this element.
            dp[x + 1] = dp.get(x, 0) + 1
            # Use x as itself, extending a run that ends at x - 1.
            dp[x] = dp.get(x - 1, 0) + 1
            best = max(best, dp[x], dp[x + 1])
        return best
