from typing import List


class Solution:
    def smallestStableIndex(self, nums: List[int], k: int) -> int:
        """
        3903. Smallest Stable Index I
        Time: O(n)
        Space: O(n)
        """
        n = len(nums)

        # suf_min[i] = min(nums[i..n-1])
        suf_min = [0] * n
        suf_min[n - 1] = nums[n - 1]
        for i in range(n - 2, -1, -1):
            suf_min[i] = min(nums[i], suf_min[i + 1])

        # Running prefix max; scanning left to right finds the smallest index.
        pref_max = float("-inf")
        for i in range(n):
            pref_max = max(pref_max, nums[i])
            if pref_max - suf_min[i] <= k:
                return i
        return -1
