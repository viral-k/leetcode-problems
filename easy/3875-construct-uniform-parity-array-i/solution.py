from typing import List


class Solution:
    def canConstruct(self, nums1: List[int]) -> bool:
        """
        3875. Construct Uniform Parity Array I
        Time: O(n)
        Space: O(1)
        """
        odd = sum(1 for x in nums1 if x % 2)
        even = len(nums1) - odd

        # An odd element must flip parity, needing another odd at a different index.
        all_even = odd != 1
        # An even element must flip parity, needing any odd element.
        all_odd = even == 0 or odd >= 1

        return all_even or all_odd
