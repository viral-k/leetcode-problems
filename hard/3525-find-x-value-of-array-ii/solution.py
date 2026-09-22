from typing import List


class Solution:
    def resultArray(self, nums: List[int], k: int, queries: List[List[int]]) -> List[int]:
        """
        3525. Find X Value of Array II
        Time: O((n + q) * k * log n)
        Space: O(n * k)
        """
        n = len(nums)
        size = 1
        while size < n:
            size *= 2

        # node = (prod % k, cnt[x] = #non-empty prefixes with product % k == x)
        # identity: prod 1, empty histogram
        prod = [1] * (2 * size)
        cnt = [[0] * k for _ in range(2 * size)]

        def merge(pl, cl, pr, cr):
            out = cl[:]
            for x in range(k):
                if cr[x]:
                    out[pl * x % k] += cr[x]
            return pl * pr % k, out

        for i, v in enumerate(nums):
            m = v % k
            prod[size + i] = m
            cnt[size + i][m] = 1
        for node in range(size - 1, 0, -1):
            prod[node], cnt[node] = merge(
                prod[2 * node], cnt[2 * node], prod[2 * node + 1], cnt[2 * node + 1]
            )

        def update(pos, v):
            node = size + pos
            m = v % k
            prod[node] = m
            cnt[node] = [0] * k
            cnt[node][m] = 1
            node //= 2
            while node:
                prod[node], cnt[node] = merge(
                    prod[2 * node], cnt[2 * node], prod[2 * node + 1], cnt[2 * node + 1]
                )
                node //= 2

        def query(lo, hi):
            # inclusive [lo, hi]; fold left-to-right using two accumulators
            lp, lc = 1, [0] * k
            rp, rc = 1, [0] * k
            lo += size
            hi += size + 1
            while lo < hi:
                if lo & 1:
                    lp, lc = merge(lp, lc, prod[lo], cnt[lo])
                    lo += 1
                if hi & 1:
                    hi -= 1
                    rp, rc = merge(prod[hi], cnt[hi], rp, rc)
                lo //= 2
                hi //= 2
            return merge(lp, lc, rp, rc)[1]

        result = []
        for index, value, start, x in queries:
            update(index, value)
            result.append(query(start, n - 1)[x])
        return result
