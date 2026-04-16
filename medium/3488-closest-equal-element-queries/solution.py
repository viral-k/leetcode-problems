from typing import List
from collections import defaultdict


class Solution:
    def solveQueries(self, nums: List[int], queries: List[int]) -> List[int]:
        """
        3488. Closest Equal Element Queries
        Time: O(n + q)
        Space: O(n)
        """
        n = len(nums)

        # Group indices by value
        indices = defaultdict(list)
        for i, num in enumerate(nums):
            indices[num].append(i)

        # Precompute minimum distance for each index
        min_dist = [-1] * n

        for idx_list in indices.values():
            if len(idx_list) < 2:
                continue

            m = len(idx_list)
            for k, i in enumerate(idx_list):
                prev_idx = idx_list[k - 1]
                next_idx = idx_list[(k + 1) % m]

                # Circular distance to previous
                dist_prev = (i - prev_idx) % n
                dist_prev = min(dist_prev, n - dist_prev)

                # Circular distance to next
                dist_next = (next_idx - i) % n
                dist_next = min(dist_next, n - dist_next)

                min_dist[i] = min(dist_prev, dist_next)

        return [min_dist[q] for q in queries]
