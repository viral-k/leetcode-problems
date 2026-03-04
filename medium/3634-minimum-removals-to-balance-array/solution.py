from typing import List


class Solution:
    def minRemoval(self, nums: List[int], k: int) -> int:
        """
        3634. Minimum Removals to Balance Array
        Time: O(n log n)
        Space: O(1)
        """
        nums.sort()
        n = len(nums)
        
        l = 0
        max_len = 1
        
        for r in range(n):
            while nums[r] > nums[l] * k:
                l += 1
            max_len = max(max_len, r - l + 1)
        
        return n - max_len
