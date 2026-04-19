from typing import List


class Solution:
    def maxDistance(self, nums1: List[int], nums2: List[int]) -> int:
        """
        1855. Maximum Distance Between a Pair of Values
        Time: O(n + m)
        Space: O(1)
        """
        n1, n2 = len(nums1), len(nums2)
        i, j = 0, 0
        max_dist = 0

        while i < n1 and j < n2:
            if nums1[i] <= nums2[j]:
                max_dist = max(max_dist, j - i)
                j += 1
            else:
                i += 1

        return max_dist
