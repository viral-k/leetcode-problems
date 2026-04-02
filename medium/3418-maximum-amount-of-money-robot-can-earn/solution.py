from typing import List


class Solution:
    def maximumAmount(self, coins: List[List[int]]) -> int:
        """
        3418. Maximum Amount of Money Robot Can Earn
        Time: O(m × n)
        Space: O(m × n)
        """
        m, n = len(coins), len(coins[0])

        dp = [[[float('-inf')] * 3 for _ in range(n)] for _ in range(m)]

        if coins[0][0] >= 0:
            for k in range(3):
                dp[0][0][k] = coins[0][0]
        else:
            dp[0][0][0] = coins[0][0]
            dp[0][0][1] = 0
            dp[0][0][2] = 0

        for i in range(m):
            for j in range(n):
                if i == 0 and j == 0:
                    continue

                for k in range(3):
                    best_prev = float('-inf')

                    if i > 0:
                        best_prev = max(best_prev, dp[i - 1][j][k])
                    if j > 0:
                        best_prev = max(best_prev, dp[i][j - 1][k])

                    if best_prev == float('-inf'):
                        continue

                    val = coins[i][j]

                    dp[i][j][k] = max(dp[i][j][k], best_prev + val)

                    if val < 0 and k > 0:
                        best_prev_k_minus = float('-inf')
                        if i > 0:
                            best_prev_k_minus = max(best_prev_k_minus, dp[i - 1][j][k - 1])
                        if j > 0:
                            best_prev_k_minus = max(best_prev_k_minus, dp[i][j - 1][k - 1])

                        dp[i][j][k] = max(dp[i][j][k], best_prev_k_minus)

        return max(dp[m - 1][n - 1])
