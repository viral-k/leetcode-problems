from typing import List


class Solution:
    def pathExistenceQueries(self, n: int, nums: List[int], maxDiff: int, queries: List[List[int]]) -> List[int]:
        """
        3534. Path Existence Queries in a Graph II
        Time: O((n + q) log n)
        Space: O(n log n)
        """
        # Sort nodes by value; rank[node] = its position in sorted order.
        order = sorted(range(n), key=lambda i: nums[i])
        vals = [nums[i] for i in order]
        rank = [0] * n
        for k, node in enumerate(order):
            rank[node] = k

        # R[i] = farthest sorted index reachable in one hop from i.
        R = [0] * n
        j = 0
        for i in range(n):
            if j < i:
                j = i
            while j + 1 < n and vals[j + 1] - vals[i] <= maxDiff:
                j += 1
            R[i] = j

        # Component ids via consecutive gaps.
        comp = [0] * n
        for i in range(1, n):
            comp[i] = comp[i - 1] + (1 if vals[i] - vals[i - 1] > maxDiff else 0)

        # Binary lifting on the farthest-jump function.
        LOG = max(1, n.bit_length())
        up = [R]  # up[0]
        for _ in range(1, LOG):
            prev = up[-1]
            cur = [prev[prev[i]] for i in range(n)]
            up.append(cur)

        ans = []
        for u, v in queries:
            su, sv = rank[u], rank[v]
            if su > sv:
                su, sv = sv, su
            if su == sv:
                ans.append(0)
            elif comp[su] != comp[sv]:
                ans.append(-1)
            else:
                cur = su
                steps = 0
                for k in range(LOG - 1, -1, -1):
                    if up[k][cur] < sv:
                        cur = up[k][cur]
                        steps += 1 << k
                ans.append(steps + 1)  # one final jump reaches sv
        return ans
