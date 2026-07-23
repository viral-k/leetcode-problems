from typing import List


class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        """
        3513. Number of Unique XOR Triplets I
        Time: O(1)
        Space: O(1)
        """
        n = len(nums)
        if n <= 2:
            return n  # n=1 -> 1, n=2 -> 2
        return 1 << n.bit_length()  # full range [0, 2^B - 1]
