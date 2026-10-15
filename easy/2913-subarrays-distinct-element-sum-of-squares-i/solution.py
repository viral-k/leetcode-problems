from typing import List


class Solution:
    def sumCounts(self, nums: List[int]) -> int:
        """
        2913. Subarrays Distinct Element Sum of Squares I
        Time: O(n^2)
        Space: O(V) where V = 100 is the value range
        """
        n = len(nums)
        total = 0

        for i in range(n):
            # nums[i] <= 100, so membership is a direct lookup
            seen = [False] * 101
            distinct = 0
            for j in range(i, n):
                v = nums[j]
                if not seen[v]:
                    seen[v] = True
                    distinct += 1
                total += distinct * distinct

        return total
