class Solution:
    def superEggDrop(self, k: int, n: int) -> int:
        """
        887. Super Egg Drop
        Time: O(k * m) ~ O(k log n)
        Space: O(k)
        """
        # dp[j] = max floors resolvable with j eggs at the current move count.
        dp = [0] * (k + 1)
        moves = 0

        while dp[k] < n:
            moves += 1
            for j in range(k, 0, -1):
                dp[j] = dp[j] + dp[j - 1] + 1

        return moves
