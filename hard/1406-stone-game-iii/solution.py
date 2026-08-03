from typing import List


class Solution:
    def stoneGameIII(self, stoneValue: List[int]) -> str:
        """
        1406. Stone Game III
        Time: O(n)
        Space: O(n)
        """
        n = len(stoneValue)
        dp = [0] * (n + 1)  # dp[i] = best (current - opponent) diff from index i

        for i in range(n - 1, -1, -1):
            best = float("-inf")
            take = 0
            for k in range(1, 4):
                if i + k > n:
                    break
                take += stoneValue[i + k - 1]
                best = max(best, take - dp[i + k])
            dp[i] = best

        if dp[0] > 0:
            return "Alice"
        if dp[0] < 0:
            return "Bob"
        return "Tie"
