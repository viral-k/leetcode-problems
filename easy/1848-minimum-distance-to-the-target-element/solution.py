from typing import List


class Solution:
    def getMinDistance(self, nums: List[int], target: int, start: int) -> int:
        """
        1848. Minimum Distance to the Target Element
        Time: O(n)
        Space: O(1)
        """
        min_dist = float('inf')

        for i, num in enumerate(nums):
            if num == target:
                min_dist = min(min_dist, abs(i - start))

        return min_dist
