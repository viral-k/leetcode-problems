from typing import List


class Solution:
    def minOperations(self, nums: List[int]) -> int:
        """
        3942. Minimum Operations to Sort a Permutation
        Time: O(n)
        Space: O(1)
        """
        n = len(nums)
        p = nums.index(0)

        best = -1

        # nums is Rot^p of the sorted array: reading forward from 0 gives
        # 0, 1, ..., n-1. Either L^p, or reverse-rotate-reverse for a cheap
        # rotate-right when p is close to n.
        if all(nums[(p + i) % n] == i for i in range(n)):
            best = min(p, n - p + 2)

        # nums is a rotation of the reversed sorted array: reading backward
        # from 0 gives 0, 1, ..., n-1. Either R then L^k, or L^(n-k) then R.
        if all(nums[(p - i) % n] == i for i in range(n)):
            k = n - 1 - p
            cost = min(k + 1, n - k + 1)
            best = cost if best < 0 else min(best, cost)

        return best
