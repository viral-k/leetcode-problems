from typing import List


class Solution:
    def minimumTotalDistance(self, robot: List[int], factory: List[List[int]]) -> int:
        """
        2463. Minimum Total Distance Traveled
        Time: O(n × m) where m = sum of factory limits
        Space: O(n × m)
        """
        robot.sort()
        factory.sort()

        # Expand factories into individual slots
        slots = []
        for pos, limit in factory:
            slots.extend([pos] * limit)

        n, m = len(robot), len(slots)

        # dp[i][j] = min distance to assign first i robots to first j slots
        dp = [[float('inf')] * (m + 1) for _ in range(n + 1)]

        # Base case: 0 robots need 0 distance
        for j in range(m + 1):
            dp[0][j] = 0

        for i in range(1, n + 1):
            for j in range(1, m + 1):
                # Don't use slot j for robot i
                dp[i][j] = dp[i][j - 1]

                # Use slot j for robot i
                dp[i][j] = min(dp[i][j], dp[i - 1][j - 1] + abs(robot[i - 1] - slots[j - 1]))

        return dp[n][m]
