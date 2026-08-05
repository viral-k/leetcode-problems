from typing import List
from collections import deque


class Solution:
    def remainingMethods(self, n: int, k: int, invocations: List[List[int]]) -> List[int]:
        """
        3310. Remove Methods From Project
        Time: O(n + m)
        Space: O(n + m)
        """
        adj = [[] for _ in range(n)]
        for a, b in invocations:
            adj[a].append(b)

        # Mark all methods reachable from k (the suspicious set).
        suspicious = [False] * n
        suspicious[k] = True
        dq = deque([k])
        while dq:
            u = dq.popleft()
            for v in adj[u]:
                if not suspicious[v]:
                    suspicious[v] = True
                    dq.append(v)

        # If any non-suspicious method invokes a suspicious one, we can't remove.
        for a, b in invocations:
            if not suspicious[a] and suspicious[b]:
                return list(range(n))

        return [m for m in range(n) if not suspicious[m]]
