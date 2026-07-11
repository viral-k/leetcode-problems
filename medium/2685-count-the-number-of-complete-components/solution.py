from typing import List


class Solution:
    def countCompleteComponents(self, n: int, edges: List[List[int]]) -> int:
        """
        2685. Count the Number of Complete Components
        Time: O(n + m * alpha(n))
        Space: O(n)
        """
        parent = list(range(n))
        size = [1] * n

        def find(x: int) -> int:
            while parent[x] != x:
                parent[x] = parent[parent[x]]
                x = parent[x]
            return x

        def union(a: int, b: int) -> None:
            ra, rb = find(a), find(b)
            if ra != rb:
                if size[ra] < size[rb]:
                    ra, rb = rb, ra
                parent[rb] = ra
                size[ra] += size[rb]

        for a, b in edges:
            union(a, b)

        # Count edges per component root.
        edge_count = {}
        for a, b in edges:
            r = find(a)
            edge_count[r] = edge_count.get(r, 0) + 1

        result = 0
        for v in range(n):
            if find(v) == v:  # v is a root
                k = size[v]
                if edge_count.get(v, 0) == k * (k - 1) // 2:
                    result += 1
        return result
