from typing import List


class Solution:
    def canConstruct(self, nums1: List[int]) -> bool:
        """
        3876. Construct Uniform Parity Array II
        Time: O(n)
        Space: O(1)
        """
        INF = float("inf")
        min_odd = INF
        min_even = INF
        odd_count = 0

        for x in nums1:
            if x % 2:
                odd_count += 1
                if x < min_odd:
                    min_odd = x
            elif x < min_even:
                min_even = x

        even_count = len(nums1) - odd_count

        # The smallest odd can never flip (nothing odd is below it),
        # so any odd element blocks an all-even result.
        all_even = odd_count == 0
        # Every even must flip, which needs an odd strictly below it.
        all_odd = even_count == 0 or (odd_count >= 1 and min_odd < min_even)

        return all_even or all_odd
