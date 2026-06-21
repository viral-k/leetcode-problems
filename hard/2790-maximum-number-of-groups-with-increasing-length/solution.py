from typing import List


class Solution:
    def maxIncreasingGroups(self, usageLimits: List[int]) -> int:
        """
        2790. Maximum Number of Groups With Increasing Length
        Time: O(n log n)
        Space: O(1)
        """
        usageLimits.sort()

        running = 0
        groups = 0

        for limit in usageLimits:
            running += limit
            if running >= groups + 1:
                running -= groups + 1
                groups += 1

        return groups
