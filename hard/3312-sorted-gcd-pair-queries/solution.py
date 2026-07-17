from typing import List
from bisect import bisect_right


class Solution:
    def gcdValues(self, nums: List[int], queries: List[int]) -> List[int]:
        """
        3312. Sorted GCD Pair Queries
        Time: O(V log V + q log V)
        Space: O(V)
        """
        V = max(nums)
        cnt = [0] * (V + 1)
        for x in nums:
            cnt[x] += 1

        # multiples[g] = how many elements are divisible by g (harmonic sieve).
        multiples = [0] * (V + 1)
        for g in range(1, V + 1):
            for m in range(g, V + 1, g):
                multiples[g] += cnt[m]

        # f[g] = pairs with gcd exactly g, via inclusion-exclusion from the top.
        f = [0] * (V + 1)
        for g in range(V, 0, -1):
            total = multiples[g] * (multiples[g] - 1) // 2  # gcd divisible by g
            for m in range(2 * g, V + 1, g):
                total -= f[m]
            f[g] = total

        # prefix[g] = number of sorted gcdPairs entries that are <= g.
        prefix = [0] * (V + 1)
        for g in range(1, V + 1):
            prefix[g] = prefix[g - 1] + f[g]

        # Query index q -> smallest g with prefix[g] > q.
        return [bisect_right(prefix, q) for q in queries]
