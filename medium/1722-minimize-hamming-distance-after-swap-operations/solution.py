from typing import List
from collections import defaultdict, Counter


class Solution:
    def minimumHammingDistance(
        self, source: List[int], target: List[int], allowedSwaps: List[List[int]]
    ) -> int:
        """
        1722. Minimize Hamming Distance After Swap Operations
        Time: O(n * α(n))
        Space: O(n)
        """
        n = len(source)
        parent = list(range(n))
        rank = [0] * n

        def find(x: int) -> int:
            if parent[x] != x:
                parent[x] = find(parent[x])
            return parent[x]

        def union(x: int, y: int) -> None:
            px, py = find(x), find(y)
            if px == py:
                return
            if rank[px] < rank[py]:
                px, py = py, px
            parent[py] = px
            if rank[px] == rank[py]:
                rank[px] += 1

        # Build connected components
        for a, b in allowedSwaps:
            union(a, b)

        # Group indices by root
        groups = defaultdict(list)
        for i in range(n):
            groups[find(i)].append(i)

        # Count unmatched positions
        hamming = 0
        for indices in groups.values():
            source_count = Counter(source[i] for i in indices)
            for i in indices:
                if source_count[target[i]] > 0:
                    source_count[target[i]] -= 1
                else:
                    hamming += 1

        return hamming
