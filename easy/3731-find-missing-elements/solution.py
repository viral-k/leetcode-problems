from typing import List


class Solution:
    def missingElements(self, nums: List[int]) -> List[int]:
        """
        3731. Find Missing Elements
        Time: O(n + R)  (R = max - min)
        Space: O(n)
        """
        present = set(nums)
        lo, hi = min(nums), max(nums)
        return [v for v in range(lo, hi + 1) if v not in present]
