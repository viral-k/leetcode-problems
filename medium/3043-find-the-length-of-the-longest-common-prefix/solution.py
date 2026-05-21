from typing import List


class Solution:
    def longestCommonPrefix(self, arr1: List[int], arr2: List[int]) -> int:
        """
        3043. Find the Length of the Longest Common Prefix
        Time: O((n + m) * D), where D is the maximum digit count
        Space: O(n * D)
        """
        prefixes = set()

        for num in arr1:
            prefix = num
            while prefix > 0:
                prefixes.add(prefix)
                prefix //= 10

        longest = 0
        for num in arr2:
            prefix = num
            while prefix > 0:
                if prefix in prefixes:
                    longest = max(longest, len(str(prefix)))
                    break
                prefix //= 10

        return longest
