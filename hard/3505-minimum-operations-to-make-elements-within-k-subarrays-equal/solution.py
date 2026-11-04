from typing import List
import heapq


class Solution:
    def minOperations(self, nums: List[int], x: int, k: int) -> int:
        """
        3505. Minimum Operations to Make Elements Within K Subarrays Equal
        Time: O(n log n + n * k)
        Space: O(n)
        """
        n = len(nums)

        # Unique ranks: order[r] is the index with rank r, so the heaps hold
        # plain ints and equal values stay distinguishable.
        order = sorted(range(n), key=lambda i: (nums[i], i))
        rank = [0] * n
        for r, i in enumerate(order):
            rank[i] = r

        # Sliding median. lo is a max-heap (negated ranks) of the lower half,
        # hi a min-heap of the upper half. Counts and sums cover live elements
        # only; an entry left of the window is dropped when it reaches a top.
        lo, hi = [], []
        lo_size = hi_size = lo_sum = hi_sum = 0
        side = [0] * n  # 0 = in lo, 1 = in hi
        left = 0

        def clean() -> None:
            while lo and order[-lo[0]] < left:
                heapq.heappop(lo)
            while hi and order[hi[0]] < left:
                heapq.heappop(hi)

        cost = [0] * (n - x + 1)
        for i in range(n):
            # Add nums[i] to the half it belongs in.
            clean()
            r = rank[i]
            if lo and r < -lo[0]:
                heapq.heappush(lo, -r)
                side[i] = 0
                lo_size += 1
                lo_sum += nums[i]
            else:
                heapq.heappush(hi, r)
                side[i] = 1
                hi_size += 1
                hi_sum += nums[i]

            # Drop the element leaving the window.
            if i >= x:
                out = i - x
                left = out + 1
                if side[out] == 0:
                    lo_size -= 1
                    lo_sum -= nums[out]
                else:
                    hi_size -= 1
                    hi_sum -= nums[out]

            # Rebalance so lo holds ceil(size / 2) live elements.
            clean()
            while lo_size > hi_size + 1:
                j = order[-heapq.heappop(lo)]
                heapq.heappush(hi, rank[j])
                side[j] = 1
                lo_size -= 1
                lo_sum -= nums[j]
                hi_size += 1
                hi_sum += nums[j]
                clean()
            while lo_size < hi_size:
                j = order[heapq.heappop(hi)]
                heapq.heappush(lo, -rank[j])
                side[j] = 0
                hi_size -= 1
                hi_sum -= nums[j]
                lo_size += 1
                lo_sum += nums[j]
                clean()

            if i >= x - 1:
                m = nums[order[-lo[0]]]
                cost[i - x + 1] = m * lo_size - lo_sum + hi_sum - m * hi_size

        # dp[i] = cheapest way to fit the current number of windows in the
        # first i elements.
        INF = float("inf")
        dp = [0] * (n + 1)
        for j in range(1, k + 1):
            ndp = [INF] * (n + 1)
            for i in range(j * x, n + 1):
                ndp[i] = min(ndp[i - 1], dp[i - x] + cost[i - x])
            dp = ndp

        return dp[n]
