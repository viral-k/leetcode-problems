from typing import List
from collections import deque


class Solution:
    def findMaxPathScore(self, edges: List[List[int]], online: List[bool], k: int) -> int:
        """
        3620. Network Recovery Pathways
        Time: O((n + m) log m)
        Space: O(n + m)
        """
        # n is the number of nodes; infer from online.
        n = len(online)
        INF = float("inf")

        # Adjacency list and in-degrees for a single topological sort.
        adj = [[] for _ in range(n)]
        indeg = [0] * n
        for u, v, c in edges:
            adj[u].append((v, c))
            indeg[v] += 1

        # Kahn's topological order (computed once, reused across checks).
        topo = []
        dq = deque(i for i in range(n) if indeg[i] == 0)
        deg = indeg[:]
        while dq:
            u = dq.popleft()
            topo.append(u)
            for v, _ in adj[u]:
                deg[v] -= 1
                if deg[v] == 0:
                    dq.append(v)

        def feasible(x: int) -> bool:
            # Min total cost from 0 to n-1 using edges with cost >= x
            # and only online nodes.
            dist = [INF] * n
            dist[0] = 0
            for u in topo:
                du = dist[u]
                if du == INF or not online[u]:
                    continue
                for v, c in adj[u]:
                    if c >= x and online[v] and du + c < dist[v]:
                        dist[v] = du + c
            return dist[n - 1] <= k

        costs = sorted({c for _, _, c in edges})
        if not costs or not feasible(costs[0]):
            return -1

        # Largest candidate cost x with feasible(x).
        lo, hi, ans = 0, len(costs) - 1, -1
        while lo <= hi:
            mid = (lo + hi) // 2
            if feasible(costs[mid]):
                ans = costs[mid]
                lo = mid + 1
            else:
                hi = mid - 1
        return ans
