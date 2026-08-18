from typing import List
from collections import defaultdict


class Solution:
    def largestInteger(self, nums: List[int], k: int) -> int:
        """
        3471. Find the Largest Almost Missing Integer
        Time: O(n * k)
        Space: O(n)
        """
        n = len(nums)
        windows = defaultdict(int)  # value -> number of size-k windows containing it

        for i in range(n - k + 1):
            # a value repeated inside one window still counts that window once
            for v in set(nums[i:i + k]):
                windows[v] += 1

        best = -1
        for v, c in windows.items():
            if c == 1 and v > best:
                best = v
        return best
