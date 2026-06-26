from typing import List


class Solution:
    def countSubarrays(self, nums: List[int], target: int) -> int:
        """
        3739. Count Subarrays With Majority Element II
        Time: O(n)
        Space: O(n)
        """
        n = len(nums)
        # freq[v] = how many prefix sums seen so far equal value v (shifted by n).
        freq = [0] * (2 * n + 1)
        i = n            # current prefix sum, shifted: i = n means s = 0
        freq[i] = 1      # register s[0] = 0
        pref = 0         # count of earlier prefixes strictly less than current
        res = 0

        for num in nums:
            if num == target:
                # prefix goes up: prefixes equal to old i become strictly less
                pref += freq[i]
                i += 1
            else:
                # prefix goes down: prefixes equal to new i are no longer less
                i -= 1
                pref -= freq[i]
            freq[i] += 1
            res += pref
        return res
