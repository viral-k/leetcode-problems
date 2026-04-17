from typing import List


class Solution:
    def minDistance(self, nums: List[int]) -> int:
        """
        3761. Minimum Absolute Distance Between Mirror Pairs
        Time: O(n)
        Space: O(n)
        """
        def reverse(x: int) -> int:
            return int(str(x)[::-1])

        n = len(nums)
        min_dist = float('inf')

        # Map: value -> smallest index seen (processing right to left)
        value_to_idx = {}

        for i in range(n - 1, -1, -1):
            target = reverse(nums[i])

            # Check if target exists at some j > i
            if target in value_to_idx:
                min_dist = min(min_dist, value_to_idx[target] - i)

            # Store this value with current index
            value_to_idx[nums[i]] = i

        return min_dist if min_dist != float('inf') else -1
