from collections import deque
from typing import List


class Solution:
    def assignEdgeWeights(self, edges: List[List[int]], queries: List[List[int]]) -> List[int]:
        """
        3559. Number of Ways to Assign Edge Weights II
        Time: O((n + q) log n)
        Space: O(n log n)
        """
        MOD = 10**9 + 7
        n = len(edges) + 1

        adj = [[] for _ in range(n + 1)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        LOG = max(1, n.bit_length())
        up = [[0] * (n + 1) for _ in range(LOG)]
        depth = [0] * (n + 1)

        # BFS from root to set depth and immediate parent (up[0]).
        visited = [False] * (n + 1)
        visited[1] = True
        queue = deque([1])
        while queue:
            node = queue.popleft()
            for neighbor in adj[node]:
                if not visited[neighbor]:
                    visited[neighbor] = True
                    depth[neighbor] = depth[node] + 1
                    up[0][neighbor] = node
                    queue.append(neighbor)

        # Binary lifting table.
        for k in range(1, LOG):
            up_k, up_prev = up[k], up[k - 1]
            for v in range(1, n + 1):
                up_k[v] = up_prev[up_prev[v]]

        pow2 = [1] * (n + 1)
        for i in range(1, n + 1):
            pow2[i] = pow2[i - 1] * 2 % MOD

        def lca(a: int, b: int) -> int:
            if depth[a] < depth[b]:
                a, b = b, a
            diff = depth[a] - depth[b]
            for k in range(LOG):
                if (diff >> k) & 1:
                    a = up[k][a]
            if a == b:
                return a
            for k in range(LOG - 1, -1, -1):
                if up[k][a] != up[k][b]:
                    a = up[k][a]
                    b = up[k][b]
            return up[0][a]

        answer = []
        for u, v in queries:
            d = depth[u] + depth[v] - 2 * depth[lca(u, v)]
            answer.append(pow2[d - 1] if d >= 1 else 0)

        return answer
