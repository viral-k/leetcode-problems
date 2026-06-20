from typing import List


class Solution:
    def maxBuilding(self, n: int, restrictions: List[List[int]]) -> int:
        """
        1840. Maximum Building Height
        Time: O(r log r)
        Space: O(r)
        """
        restrictions.append([1, 0])
        restrictions.sort()
        r = len(restrictions)

        # Forward pass: each checkpoint is bounded by what's reachable from the left.
        for i in range(1, r):
            gap = restrictions[i][0] - restrictions[i - 1][0]
            restrictions[i][1] = min(restrictions[i][1], restrictions[i - 1][1] + gap)

        # Backward pass: each checkpoint is bounded by what's reachable from the right.
        for i in range(r - 2, -1, -1):
            gap = restrictions[i + 1][0] - restrictions[i][0]
            restrictions[i][1] = min(restrictions[i][1], restrictions[i + 1][1] + gap)

        ans = 0

        # Peak between every pair of consecutive checkpoints.
        for i in range(r - 1):
            id1, h1 = restrictions[i]
            id2, h2 = restrictions[i + 1]
            ans = max(ans, (h1 + h2 + (id2 - id1)) // 2)

        # Free climb from the last checkpoint to building n.
        last_id, last_h = restrictions[-1]
        ans = max(ans, last_h + (n - last_id))

        return ans
