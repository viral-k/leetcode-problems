from collections import deque
from typing import List


class Solution:
    def assignEdgeWeights(self, edges: List[List[int]]) -> int:
        """
        3558. Number of Ways to Assign Edge Weights I
        Time: O(n)
        Space: O(n)
        """
        MOD = 10**9 + 7
        n = len(edges) + 1

        adj = [[] for _ in range(n + 1)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        # BFS from the root (node 1) to find the maximum depth in edges.
        max_depth = 0
        visited = [False] * (n + 1)
        visited[1] = True
        queue = deque([(1, 0)])

        while queue:
            node, depth = queue.popleft()
            max_depth = max(max_depth, depth)
            for neighbor in adj[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    queue.append((neighbor, depth + 1))

        return pow(2, max_depth - 1, MOD)
