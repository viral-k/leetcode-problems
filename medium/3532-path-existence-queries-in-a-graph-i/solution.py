from typing import List


class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[bool]:
        """
        3532. Path Existence Queries in a Graph I
        Time: O(n + q)
        Space: O(n)
        """
        # Component id: increments whenever a consecutive gap exceeds maxDiff.
        comp = [0] * n
        for i in range(1, n):
            comp[i] = comp[i - 1] + (1 if nums[i] - nums[i - 1] > maxDiff else 0)

        return [comp[u] == comp[v] for u, v in queries]
