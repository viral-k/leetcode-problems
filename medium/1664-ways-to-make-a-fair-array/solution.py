from typing import List


class Solution:
    def waysToMakeFair(self, nums: List[int]) -> int:
        """
        1664. Ways to Make a Fair Array
        Time: O(n)
        Space: O(1)
        """
        n = len(nums)
        total_even = sum(nums[i] for i in range(0, n, 2))
        total_odd = sum(nums[i] for i in range(1, n, 2))

        pre_even = pre_odd = 0
        count = 0
        for i, x in enumerate(nums):
            # suffix sums (after i), excluding nums[i] itself
            if i % 2 == 0:
                suf_even = total_even - pre_even - x
                suf_odd = total_odd - pre_odd
            else:
                suf_even = total_even - pre_even
                suf_odd = total_odd - pre_odd - x
            # removal flips suffix parity
            if pre_even + suf_odd == pre_odd + suf_even:
                count += 1
            # advance prefix with nums[i]
            if i % 2 == 0:
                pre_even += x
            else:
                pre_odd += x
        return count
