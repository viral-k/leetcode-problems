from typing import List


class Solution:
    def lexicographicallySmallestArray(self, nums: List[int], limit: int) -> List[int]:
        """
        2948. Make Lexicographically Smallest Array by Swapping Elements
        Time: O(n log n)
        Space: O(n)
        """
        n = len(nums)
        order = sorted(range(n), key=lambda i: nums[i])

        result = [0] * n
        start = 0
        while start < n:
            # Extend the group while consecutive sorted values stay within limit.
            end = start + 1
            while end < n and nums[order[end]] - nums[order[end - 1]] <= limit:
                end += 1

            # The group owns these positions and these values; pair them in order.
            indices = sorted(order[start:end])
            for k, idx in enumerate(indices):
                result[idx] = nums[order[start + k]]

            start = end

        return result
