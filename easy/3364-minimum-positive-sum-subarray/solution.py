from bisect import bisect_left, insort
from typing import List


class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        """
        3364. Minimum Positive Sum Subarray
        Time: O(n * r), from list inserts; the searches are O(log r)
        Space: O(n)
        """
        prefix = [0]
        for x in nums:
            prefix.append(prefix[-1] + x)

        # window = sorted prefix[i] for every allowed start i in [j - r, j - l]
        window = []
        best = float("inf")
        for j in range(l, len(prefix)):
            insort(window, prefix[j - l])
            if j - r - 1 >= 0:
                window.pop(bisect_left(window, prefix[j - r - 1]))
            # The largest prefix[i] < prefix[j] gives the smallest positive sum.
            idx = bisect_left(window, prefix[j]) - 1
            if idx >= 0:
                best = min(best, prefix[j] - window[idx])

        return best if best != float("inf") else -1
