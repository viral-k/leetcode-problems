from typing import List


class Solution:
    def sortPermutation(self, nums: List[int]) -> int:
        """
        3644. Maximum K to Sort a Permutation
        Time: O(n)
        Space: O(1)
        """
        # k has to be a submask of every misplaced value, since each of them
        # must take part in a swap. The largest such k is their AND, and that
        # value is always reachable: the element k itself satisfies
        # k AND v == k for every misplaced v, so it can carry them all home.
        k = -1
        for i, v in enumerate(nums):
            if v != i:
                k &= v

        return 0 if k == -1 else k
