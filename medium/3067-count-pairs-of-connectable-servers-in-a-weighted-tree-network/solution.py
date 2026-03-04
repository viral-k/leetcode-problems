from typing import List
from collections import defaultdict


class Solution:
    def countPairsOfConnectableServers(self, edges: List[List[int]], signalSpeed: int) -> List[int]:
        """
        3067. Count Pairs of Connectable Servers in a Weighted Tree Network
        Time: O(n²)
        Space: O(n)
        """
        n = len(edges) + 1
        graph = defaultdict(list)

        for u, v, w in edges:
            graph[u].append((v, w))
            graph[v].append((u, w))

        result = [0] * n

        def dfs(node: int, parent: int, dist: int) -> int:
            count = 1 if dist % signalSpeed == 0 else 0
            for nei, w in graph[node]:
                if nei == parent:
                    continue
                count += dfs(nei, node, dist + w)
            return count

        for c in range(n):
            branch_counts = []

            for nei, w in graph[c]:
                branch_counts.append(dfs(nei, c, w))

            total = 0
            prefix = 0
            for cnt in branch_counts:
                total += prefix * cnt
                prefix += cnt

            result[c] = total

        return result
