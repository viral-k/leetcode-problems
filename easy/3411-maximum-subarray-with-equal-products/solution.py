from typing import List


class Solution:
    def maxLength(self, nums: List[int]) -> int:
        """
        3411. Maximum Subarray With Equal Products
        Time: O(n)
        Space: O(1)
        """
        # Any pair satisfies a * b == gcd * lcm. For 3 or more elements the
        # condition holds exactly when they are pairwise coprime.
        last = {2: -1, 3: -1, 5: -1, 7: -1}  # last index divisible by each prime
        best = 2
        left = 0
        for i, x in enumerate(nums):
            for p in last:
                if x % p == 0:
                    left = max(left, last[p] + 1)
                    last[p] = i
            best = max(best, i - left + 1)
        return best
