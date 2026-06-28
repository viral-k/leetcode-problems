from typing import List


class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        """
        1846. Maximum Element After Decreasing and Rearranging
        Time: O(n log n)
        Space: O(1)
        """
        arr.sort()
        prev = 1  # first element must be 1
        for i in range(1, len(arr)):
            # can only decrease, and must stay within +1 of the previous
            prev = min(arr[i], prev + 1)
        return prev
