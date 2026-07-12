from typing import List


class Solution:
    def arrayRankTransform(self, arr: List[int]) -> List[int]:
        """
        1331. Rank Transform of an Array
        Time: O(n log n)
        Space: O(n)
        """
        rank = {v: i + 1 for i, v in enumerate(sorted(set(arr)))}
        return [rank[v] for v in arr]
