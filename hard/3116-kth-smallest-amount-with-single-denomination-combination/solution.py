from typing import List
from math import gcd


class Solution:
    def findKthSmallest(self, coins: List[int], k: int) -> int:
        """
        3116. Kth Smallest Amount With Single Denomination Combination
        Time: O(2^m * log(k * minCoin))
        Space: O(2^m)
        """
        # Drop coins that are multiples of another coin: their multiples
        # are already covered, so they add nothing to the union.
        base = []
        for c in sorted(coins):
            if not any(c % d == 0 for d in base):
                base.append(c)

        n = len(base)
        hi = k * base[0]  # smallest coin alone reaches k multiples by here

        # Inclusion-exclusion terms: (lcm, sign). Subsets whose lcm exceeds
        # hi always contribute 0, so they are skipped (also avoids overflow).
        terms = []
        for mask in range(1, 1 << n):
            lcm = 1
            for i in range(n):
                if mask >> i & 1:
                    lcm = lcm // gcd(lcm, base[i]) * base[i]
                    if lcm > hi:
                        break
            else:
                sign = 1 if bin(mask).count("1") % 2 else -1
                terms.append((lcm, sign))

        def count(x: int) -> int:
            # how many reachable amounts are <= x
            return sum(sign * (x // lcm) for lcm, sign in terms)

        lo = 1
        while lo < hi:
            mid = (lo + hi) // 2
            if count(mid) >= k:
                hi = mid
            else:
                lo = mid + 1
        return lo
