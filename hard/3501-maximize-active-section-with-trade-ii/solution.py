from typing import List
from bisect import bisect_left, bisect_right


class Solution:
    def maxActiveSectionsAfterTrade(self, s: str, queries: List[List[int]]) -> List[int]:
        """
        3501. Maximize Active Section with Trade II
        Time: O(n log n + q log n)
        Space: O(n log n)
        """
        n = len(s)
        total_ones = s.count("1")

        # Maximal zero-runs of s.
        starts, ends, lengths = [], [], []
        i = 0
        while i < n:
            if s[i] == "0":
                j = i
                while j < n and s[j] == "0":
                    j += 1
                starts.append(i)
                ends.append(j - 1)
                lengths.append(j - i)
                i = j
            else:
                i += 1

        cnt = len(starts)

        # P[i] = full adjacent-pair sum; sparse table for range max.
        P = [lengths[i] + lengths[i + 1] for i in range(cnt - 1)]
        m = len(P)
        LOG = max(1, m.bit_length())
        sparse = [P[:]] if m else [[]]
        k = 1
        while (1 << k) <= m:
            prev = sparse[k - 1]
            span = 1 << (k - 1)
            sparse.append([max(prev[i], prev[i + span]) for i in range(m - (1 << k) + 1)])
            k += 1

        def range_max(lo: int, hi: int) -> int:
            # max of P[lo..hi]; caller guarantees lo <= hi and valid bounds
            k = (hi - lo + 1).bit_length() - 1
            return max(sparse[k][lo], sparse[k][hi - (1 << k) + 1])

        ans = []
        for l, r in queries:
            a = bisect_left(ends, l)          # first run with end >= l
            b = bisect_right(starts, r) - 1   # last run with start <= r

            if a > b or a >= cnt or b < 0:
                ans.append(total_ones)
                continue
            if a == b:
                # single zero-run: no adjacent partner, no valid trade
                ans.append(total_ones)
                continue

            len_a = min(ends[a], r) - max(starts[a], l) + 1
            len_b = min(ends[b], r) - max(starts[b], l) + 1

            # leading pair (a, a+1) and trailing pair (b-1, b)
            gain = len_a + (len_b if a + 1 == b else lengths[a + 1])
            gain = max(gain, (len_a if b - 1 == a else lengths[b - 1]) + len_b)

            # fully-interior pairs
            if a + 1 <= b - 2:
                gain = max(gain, range_max(a + 1, b - 2))

            ans.append(total_ones + gain)
        return ans
