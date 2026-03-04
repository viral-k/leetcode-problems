from typing import List


class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        """
        3719. Longest Balanced Subarray I
        Time: O(n²)
        Space: O(n)
        """
        n = len(nums)
        ans = 0

        for i in range(n):
            even = set()
            odd = set()

            for j in range(i, n):
                if nums[j] % 2 == 0:
                    even.add(nums[j])
                else:
                    odd.add(nums[j])

                if len(even) == len(odd):
                    ans = max(ans, j - i + 1)

        return ans
