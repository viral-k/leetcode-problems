from typing import List
from collections import deque
import heapq


class Solution:
    def maximumSafenessFactor(self, grid: List[List[int]]) -> int:
        """
        2812. Find the Safest Path in a Grid
        Time: O(n^2 log n)
        Space: O(n^2)
        """
        n = len(grid)
        DIRS = ((1, 0), (-1, 0), (0, 1), (0, -1))

        # Phase 1: multi-source BFS -> Manhattan distance to nearest thief.
        dist = [[-1] * n for _ in range(n)]
        q = deque()
        for r in range(n):
            for c in range(n):
                if grid[r][c] == 1:
                    dist[r][c] = 0
                    q.append((r, c))
        while q:
            r, c = q.popleft()
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n and dist[nr][nc] == -1:
                    dist[nr][nc] = dist[r][c] + 1
                    q.append((nr, nc))

        # Phase 2: max-min (bottleneck) path via max-heap Dijkstra.
        best = [[-1] * n for _ in range(n)]
        best[0][0] = dist[0][0]
        heap = [(-dist[0][0], 0, 0)]  # negate for max-heap
        while heap:
            neg_b, r, c = heapq.heappop(heap)
            b = -neg_b
            if (r, c) == (n - 1, n - 1):
                return b
            if b < best[r][c]:
                continue
            for dr, dc in DIRS:
                nr, nc = r + dr, c + dc
                if 0 <= nr < n and 0 <= nc < n:
                    nb = min(b, dist[nr][nc])
                    if nb > best[nr][nc]:
                        best[nr][nc] = nb
                        heapq.heappush(heap, (-nb, nr, nc))
        return best[n - 1][n - 1]
