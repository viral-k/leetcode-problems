from typing import List


class Solution:
    def maxSum(self, nums: List[int], k: int) -> int:
        """
        2897. Apply Operations on Array to Maximize Sum of Squares
        Time: O((n + k) * 30)
        Space: O(1)
        """
        MOD = 10**9 + 7
        BITS = 30  # nums[i] <= 10^9 < 2^30

        # the operation relocates bits but never creates or destroys one, so
        # the per-bit count across the array is invariant
        cnt = [0] * BITS
        for v in nums:
            while v:
                b = v & -v
                cnt[b.bit_length() - 1] += 1
                v ^= b

        # x^2 is convex, so pack bits as densely as possible: each pick takes
        # one copy of every bit still in stock
        total = 0
        for _ in range(k):
            value = 0
            for b in range(BITS):
                if cnt[b]:
                    cnt[b] -= 1
                    value |= 1 << b
            total = (total + value * value) % MOD

        return total
