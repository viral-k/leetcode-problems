class Solution:
    def numOfWays(self, nums: list[int]) -> int:
        """
        1569. Number of Ways to Reorder Array to Get Same BST
        Time: O(n log n)
        Space: O(n)
        """
        MOD = 10**9 + 7
        n = len(nums)

        # nums is a permutation of 1..n, so pos is total
        pos = [0] * (n + 1)
        for i, v in enumerate(nums):
            pos[v] = i

        fact = [1] * (n + 1)
        for i in range(1, n + 1):
            fact[i] = fact[i - 1] * i % MOD
        inv_fact = [1] * (n + 1)
        inv_fact[n] = pow(fact[n], MOD - 2, MOD)
        for i in range(n, 0, -1):
            inv_fact[i - 1] = inv_fact[i] * i % MOD

        def comb(a: int, b: int) -> int:
            return fact[a] * inv_fact[b] % MOD * inv_fact[a - b] % MOD

        # The BST built by inserting a permutation is the treap on
        # (value, insertion index): a BST by value, a min-heap by index.
        # Walking values ascending walks the tree in order, so build it with
        # the right-spine stack sweep. 0 stands for a missing child.
        left = [0] * (n + 1)
        right = [0] * (n + 1)
        stack = []
        for v in range(1, n + 1):
            last = 0
            while stack and pos[stack[-1]] > pos[v]:
                last = stack.pop()  # younger than v, so it sinks below v
            left[v] = last
            if stack:
                right[stack[-1]] = v
            stack.append(v)
        root = stack[0]

        # Every subtree spans a contiguous value interval, so sizes come from
        # a top-down sweep without needing a post-order traversal.
        size = [0] * (n + 1)
        todo = [(root, 1, n)]
        while todo:
            v, lo, hi = todo.pop()
            size[v] = hi - lo + 1
            if left[v]:
                todo.append((left[v], lo, v - 1))
            if right[v]:
                todo.append((right[v], v + 1, hi))

        # ways = product of C(L + R, L) over nodes, with L + R = size[v] - 1
        ways = 1
        for v in range(1, n + 1):
            ways = ways * comb(size[v] - 1, size[left[v]]) % MOD

        return (ways - 1) % MOD
