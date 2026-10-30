from typing import List
import heapq


class Solution:
    def shortestPath(self, n: int, edges: List[List[int]], labels: str, k: int) -> int:
        """
        3970. Shortest Path With At Most K Consecutive Identical Characters
        Time: O(k * (n + m) log(n * k))
        Space: O(n * k + m)
        """
        adj = [[] for _ in range(n)]
        for u, v, w in edges:
            adj[u].append((v, w, labels[u] == labels[v]))

        # State id = node * K + run, where run is the length of the current
        # streak of identical labels ending at node (1..k).
        K = k + 1
        INF = float("inf")
        dist = [INF] * (n * K)
        # best[u] = smallest run already settled at u. A later pop of u with a
        # run at least that long is dominated: more distance, no better run.
        best = [K] * n

        dist[1] = 0
        heap = [(0, 1)]
        target = n - 1
        while heap:
            d, s = heapq.heappop(heap)
            if d > dist[s]:
                continue
            u, r = divmod(s, K)
            if r >= best[u]:
                continue
            best[u] = r
            if u == target:
                return d
            for v, w, same in adj[u]:
                nr = r + 1 if same else 1
                if nr > k or nr >= best[v]:
                    continue
                ns = v * K + nr
                nd = d + w
                if nd < dist[ns]:
                    dist[ns] = nd
                    heapq.heappush(heap, (nd, ns))

        return -1
