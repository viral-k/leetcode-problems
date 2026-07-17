from typing import List
from math import gcd


class Solution:
    def sumOfGcdPairs(self, nums: List[int]) -> int:
        """
        3867. Sum of GCD of Formed Pairs
        Time: O(n log n + n log V)
        Space: O(n)
        """
        prefix_gcd = []
        mx = 0
        for x in nums:
            mx = max(mx, x)          # running maximum
            prefix_gcd.append(gcd(x, mx))

        prefix_gcd.sort()

        # Pair smallest with largest, walking inward.
        total = 0
        l, r = 0, len(prefix_gcd) - 1
        while l < r:
            total += gcd(prefix_gcd[l], prefix_gcd[r])
            l += 1
            r -= 1
        return total
