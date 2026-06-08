from typing import List


class Solution:
    def pivotArray(self, nums: List[int], pivot: int) -> List[int]:
        """
        2161. Partition Array According to Given Pivot
        Time: O(n)
        Space: O(n)
        """
        less = []
        greater = []
        equal_count = 0

        for num in nums:
            if num < pivot:
                less.append(num)
            elif num > pivot:
                greater.append(num)
            else:
                equal_count += 1

        return less + [pivot] * equal_count + greater
