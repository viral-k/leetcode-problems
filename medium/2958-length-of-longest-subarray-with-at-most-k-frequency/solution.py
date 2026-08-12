from typing import List
from collections import defaultdict


class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        """
        2958. Length of Longest Subarray With at Most K Frequency
        Time: O(n)
        Space: O(n)
        """
        freq = defaultdict(int)
        left = 0
        best = 0

        for r, x in enumerate(nums):
            freq[x] += 1
            # only the just-added value can violate the limit
            while freq[x] > k:
                freq[nums[left]] -= 1
                left += 1
            best = max(best, r - left + 1)

        return best
