import heapq
from typing import List


class Solution:
    def maxTotalValue(self, nums: List[int], k: int) -> int:
        """
        3691. Maximum Total Subarray Value II
        Time: O(n log n + k log k)
        Space: O(n log n + k)
        """
        n = len(nums)

        # Sparse tables for range max and range min (O(1) queries).
        log = [0] * (n + 1)
        for i in range(2, n + 1):
            log[i] = log[i // 2] + 1

        levels = log[n] + 1
        sparse_max = [nums[:]]
        sparse_min = [nums[:]]
        for j in range(1, levels):
            half = 1 << (j - 1)
            prev_max = sparse_max[j - 1]
            prev_min = sparse_min[j - 1]
            length = n - (1 << j) + 1
            sparse_max.append(
                [max(prev_max[i], prev_max[i + half]) for i in range(length)]
            )
            sparse_min.append(
                [min(prev_min[i], prev_min[i + half]) for i in range(length)]
            )

        def value(l: int, r: int) -> int:
            j = log[r - l + 1]
            offset = r - (1 << j) + 1
            hi = max(sparse_max[j][l], sparse_max[j][offset])
            lo = min(sparse_min[j][l], sparse_min[j][offset])
            return hi - lo

        # Best-first extraction: each interval's value dominates its children,
        # so popping k times yields the k largest subarray values.
        heap = [(-value(0, n - 1), 0, n - 1)]
        visited = {(0, n - 1)}
        total = 0

        for _ in range(k):
            neg_val, l, r = heapq.heappop(heap)
            total += -neg_val

            if l + 1 <= r and (l + 1, r) not in visited:
                visited.add((l + 1, r))
                heapq.heappush(heap, (-value(l + 1, r), l + 1, r))

            if l <= r - 1 and (l, r - 1) not in visited:
                visited.add((l, r - 1))
                heapq.heappush(heap, (-value(l, r - 1), l, r - 1))

        return total
