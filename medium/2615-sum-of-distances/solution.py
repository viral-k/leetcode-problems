from typing import List
from collections import defaultdict


class Solution:
    def distance(self, nums: List[int]) -> List[int]:
        """
        2615. Sum of Distances
        Time: O(n)
        Space: O(n)
        """
        n = len(nums)
        arr = [0] * n

        # Group indices by value
        groups = defaultdict(list)
        for i, num in enumerate(nums):
            groups[num].append(i)

        # For each group, calculate distances using prefix sum
        for indices in groups.values():
            # Build prefix sum of indices
            prefix = [0]
            for idx in indices:
                prefix.append(prefix[-1] + idx)

            count = len(indices)
            for j, idx in enumerate(indices):
                # Left contribution: j * idx - sum of indices to the left
                left = idx * j - prefix[j]
                # Right contribution: sum of indices to the right - (count - j - 1) * idx
                right = (prefix[count] - prefix[j + 1]) - idx * (count - j - 1)
                arr[idx] = left + right

        return arr
