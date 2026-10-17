from typing import List


class Solution:
    def minSwaps(self, nums: List[int]) -> int:
        """
        3551. Minimum Swaps to Sort by Digit Sum
        Time: O(n log n)
        Space: O(n)
        """
        n = len(nums)

        def digit_sum(x: int) -> int:
            total = 0
            while x:
                total += x % 10
                x //= 10
            return total

        # order[t] = original index of the element that belongs at position t.
        # Values are distinct, so the key never ties and this is a permutation.
        order = sorted(range(n), key=lambda i: (digit_sum(nums[i]), nums[i]))

        # a cycle of length k needs k - 1 swaps; fixed points cost nothing
        visited = [False] * n
        swaps = 0
        for t in range(n):
            if visited[t]:
                continue
            length = 0
            j = t
            while not visited[j]:
                visited[j] = True
                j = order[j]
                length += 1
            swaps += length - 1

        return swaps
