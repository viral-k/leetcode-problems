import random


class Solution:
    def minMoves2(self, nums: list[int]) -> int:
        """
        462. Minimum Moves to Equal Array Elements II
        Time: O(n) expected
        Space: O(n)
        """
        # The median minimises the sum of absolute differences. Quickselect the
        # element of rank n // 2 with a random pivot and a three-way split.
        arr, k = nums, len(nums) // 2
        while True:
            pivot = random.choice(arr)
            lo = [x for x in arr if x < pivot]
            if k < len(lo):
                arr = lo
                continue
            hi = [x for x in arr if x > pivot]
            eq = len(arr) - len(lo) - len(hi)
            if k < len(lo) + eq:
                median = pivot
                break
            k -= len(lo) + eq
            arr = hi

        return sum(abs(x - median) for x in nums)
