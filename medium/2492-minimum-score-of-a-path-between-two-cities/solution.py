from typing import List
from collections import deque


class Solution:
    def minScore(self, n: int, roads: List[List[int]]) -> int:
        """
        2492. Minimum Score of a Path Between Two Cities
        Time: O(n + m)
        Space: O(n + m)
        """
        adj = [[] for _ in range(n + 1)]
        for a, b, d in roads:
            adj[a].append((b, d))
            adj[b].append((a, d))

        ans = float("inf")
        visited = [False] * (n + 1)
        visited[1] = True
        dq = deque([1])
        while dq:
            u = dq.popleft()
            for v, d in adj[u]:
                ans = min(ans, d)
                if not visited[v]:
                    visited[v] = True
                    dq.append(v)
        return ans
