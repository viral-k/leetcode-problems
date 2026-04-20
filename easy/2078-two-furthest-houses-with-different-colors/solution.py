from typing import List


class Solution:
    def maxDistance(self, colors: List[int]) -> int:
        """
        2078. Two Furthest Houses With Different Colors
        Time: O(n)
        Space: O(1)
        """
        n = len(colors)
        dist = 0

        # Check from first house - find furthest different color
        for j in range(n - 1, -1, -1):
            if colors[j] != colors[0]:
                dist = max(dist, j)
                break

        # Check from last house - find furthest different color
        for i in range(n):
            if colors[i] != colors[n - 1]:
                dist = max(dist, n - 1 - i)
                break

        return dist
