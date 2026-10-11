from typing import List


class Solution:
    def sumOfSquares(self, nums: List[int]) -> int:
        """
        2778. Sum of Squares of Special Elements
        Time: O(sqrt(n))
        Space: O(1)
        """
        n = len(nums)
        total = 0

        # the special positions are exactly the divisors of n, so enumerate
        # those in pairs rather than scanning every index
        i = 1
        while i * i <= n:
            if n % i == 0:
                total += nums[i - 1] ** 2  # statement is 1-indexed
                j = n // i
                if j != i:
                    total += nums[j - 1] ** 2
            i += 1

        return total
