from typing import List


class Solution:
    def longestSubsequence(self, nums: List[int]) -> int:
        """
        3702. Longest Subsequence With Non-Zero Bitwise XOR
        Time: O(n)
        Space: O(1)
        """
        total = 0
        has_nonzero = False
        for x in nums:
            total ^= x
            if x != 0:
                has_nonzero = True

        if total != 0:
            return len(nums)          # whole array works
        if has_nonzero:
            return len(nums) - 1      # drop one non-zero element
        return 0                      # all zeros: no valid subsequence
