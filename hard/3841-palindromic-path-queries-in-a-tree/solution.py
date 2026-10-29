class Solution:
    def palindromePath(self, n: int, edges: list[list[int]], s: str, queries: list[str]) -> list[bool]:
        """
        3841. Palindromic Path Queries in a Tree
        Time: O((n + q) log n)
        Space: O(n log n)
        """
        adj = [[] for _ in range(n)]
        for u, v in edges:
            adj[u].append(v)
            adj[v].append(u)

        ch = [1 << (ord(c) - 97) for c in s]

        # Iterative preorder DFS from node 0. base[x] = parity mask root..x.
        parent = [0] * n
        depth = [0] * n
        base = [0] * n
        tin = [0] * n
        order = []
        seen = [False] * n
        seen[0] = True
        base[0] = ch[0]
        stack = [0]
        while stack:
            u = stack.pop()
            tin[u] = len(order)
            order.append(u)
            for w in adj[u]:
                if not seen[w]:
                    seen[w] = True
                    parent[w] = u
                    depth[w] = depth[u] + 1
                    base[w] = base[u] ^ ch[w]
                    stack.append(w)

        size = [1] * n
        for u in reversed(order):
            if u != 0:
                size[parent[u]] += size[u]
        tout = [tin[u] + size[u] - 1 for u in range(n)]

        # Binary lifting: up[k][x] is the 2^k-th ancestor of x (root maps to itself).
        log = max(1, (n - 1).bit_length())
        up = [parent]
        for _ in range(1, log):
            prev = up[-1]
            up.append([prev[prev[x]] for x in range(n)])

        def lca(u: int, v: int) -> int:
            if depth[u] < depth[v]:
                u, v = v, u
            diff = depth[u] - depth[v]
            k = 0
            while diff:
                if diff & 1:
                    u = up[k][u]
                diff >>= 1
                k += 1
            if u == v:
                return u
            for k in range(log - 1, -1, -1):
                if up[k][u] != up[k][v]:
                    u = up[k][u]
                    v = up[k][v]
            return parent[u]

        # Fenwick tree of XOR deltas over preorder positions (1-indexed).
        tree = [0] * (n + 1)

        def add(i: int, d: int) -> None:
            i += 1
            while i <= n:
                tree[i] ^= d
                i += i & -i

        def mask_of(x: int) -> int:
            m = base[x]
            i = tin[x] + 1
            while i:
                m ^= tree[i]
                i -= i & -i
            return m

        answer = []
        for q in queries:
            parts = q.split()
            if parts[0] == "update":
                x = int(parts[1])
                new = 1 << (ord(parts[2]) - 97)
                d = ch[x] ^ new
                if d:
                    ch[x] = new
                    add(tin[x], d)
                    if tout[x] + 1 < n:
                        add(tout[x] + 1, d)
            else:
                u, v = int(parts[1]), int(parts[2])
                mask = mask_of(u) ^ mask_of(v) ^ ch[lca(u, v)]
                answer.append(mask & (mask - 1) == 0)

        return answer
