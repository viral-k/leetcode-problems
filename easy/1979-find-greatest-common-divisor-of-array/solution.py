from typing import List
from math import gcd


class Solution:
    def findGCD(self, nums: List[int]) -> int:
        """
        1979. Find Greatest Common Divisor of Array
        Time: O(n + log V)
        Space: O(1)
        """
        return gcd(min(nums), max(nums))
