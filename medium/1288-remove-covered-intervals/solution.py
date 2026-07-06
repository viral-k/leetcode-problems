from typing import List


class Solution:
    def removeCoveredIntervals(self, intervals: List[List[int]]) -> int:
        """
        1288. Remove Covered Intervals
        Time: O(n log n)
        Space: O(1)
        """
        # left ascending, right descending on ties (bigger interval first)
        intervals.sort(key=lambda x: (x[0], -x[1]))
        count = 0
        max_right = -1
        for _, r in intervals:
            if r > max_right:      # not covered by any previous interval
                count += 1
                max_right = r
        return count
