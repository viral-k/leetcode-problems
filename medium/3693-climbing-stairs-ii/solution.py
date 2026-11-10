from typing import List


class Solution:
    def climbStairs(self, n: int, costs: List[int]) -> int:
        """
        3693. Climbing Stairs II
        Time: O(n)
        Space: O(1)
        """
        INF = float("inf")
        # a, b, c = best cost to reach steps j - 3, j - 2, j - 1. Steps below 0
        # don't exist.
        a, b, c = INF, INF, 0
        for cost in costs:
            a, b, c = b, c, cost + min(c + 1, b + 4, a + 9)
        return c
