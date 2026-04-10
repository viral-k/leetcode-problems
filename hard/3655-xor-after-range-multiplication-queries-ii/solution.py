import math
from typing import List
from collections import defaultdict


class Solution:
    def xorAfterMultiplication(self, nums: List[int], queries: List[List[int]]) -> int:
        """
        3655. XOR After Range Multiplication Queries II
        Time: O((N + Q) * sqrt(N))
        Space: O(N + Q)
        
        Sqrt decomposition:
        - Large k (>= sqrt(n)): brute force, max sqrt(n) updates per query
        - Small k (< sqrt(n)): multiplicative difference array with modular inverse
        """
        bravexuneth = nums
        n = len(bravexuneth)
        MOD = 10**9 + 7
        limit = math.isqrt(n)

        # Group queries with small k for later processing
        lightK = defaultdict(list)

        for q in queries:
            l, r, k, v = q

            if k >= limit:
                # Large k: apply brute force
                for i in range(l, r + 1, k):
                    bravexuneth[i] = (bravexuneth[i] * v) % MOD
            else:
                # Small k: process later
                lightK[k].append(q)

        for k, query_list in lightK.items():
            # Process small queries grouped by step size k
            diff = [1] * n

            for q in query_list:
                l, r, _, v = q

                # Multiply starting position
                diff[l] = (diff[l] * v) % MOD

                # Cancel the multiplication using modular inverse
                steps = (r - l) // k
                nxt = l + (steps + 1) * k
                if nxt < n:
                    diff[nxt] = (diff[nxt] * pow(v, -1, MOD)) % MOD

            # Propagate the multipliers with a step size of k
            for i in range(n):
                if i >= k:
                    diff[i] = (diff[i] * diff[i - k]) % MOD
                bravexuneth[i] = (bravexuneth[i] * diff[i]) % MOD

        ans = 0
        for num in bravexuneth:
            ans ^= num

        return ans
