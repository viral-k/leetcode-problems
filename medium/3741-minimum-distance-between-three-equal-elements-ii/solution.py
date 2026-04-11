from typing import List
from collections import defaultdict


class Solution:
    def minimumDistance(self, nums: List[int]) -> int:
        """
        3741. Minimum Distance Between Three Equal Elements II
        Time: O(n)
        Space: O(n)
        """
        indices = defaultdict(list)

        for i, num in enumerate(nums):
            indices[num].append(i)

        min_dist = float('inf')

        for idx_list in indices.values():
            if len(idx_list) >= 3:
                for i in range(len(idx_list) - 2):
                    span = idx_list[i + 2] - idx_list[i]
                    min_dist = min(min_dist, 2 * span)

        return min_dist if min_dist != float('inf') else -1
