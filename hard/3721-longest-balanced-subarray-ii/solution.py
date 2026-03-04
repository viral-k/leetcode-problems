from typing import List
from collections import defaultdict, deque


class SegmentTree:
    def __init__(self, n):
        self.n = n
        self.minv = [0] * (4 * n)
        self.maxv = [0] * (4 * n)
        self.lazy = [0] * (4 * n)

    def _push(self, idx):
        if self.lazy[idx] != 0:
            for child in (idx * 2, idx * 2 + 1):
                self.minv[child] += self.lazy[idx]
                self.maxv[child] += self.lazy[idx]
                self.lazy[child] += self.lazy[idx]
            self.lazy[idx] = 0

    def _pull(self, idx):
        self.minv[idx] = min(self.minv[idx * 2], self.minv[idx * 2 + 1])
        self.maxv[idx] = max(self.maxv[idx * 2], self.maxv[idx * 2 + 1])

    def range_add(self, l, r, val, idx=1, nl=0, nr=None):
        if nr is None:
            nr = self.n - 1
        if r < nl or nr < l:
            return
        if l <= nl and nr <= r:
            self.minv[idx] += val
            self.maxv[idx] += val
            self.lazy[idx] += val
            return
        self._push(idx)
        mid = (nl + nr) // 2
        self.range_add(l, r, val, idx * 2, nl, mid)
        self.range_add(l, r, val, idx * 2 + 1, mid + 1, nr)
        self._pull(idx)

    def find_zero(self, ql, idx=1, nl=0, nr=None):
        if nr is None:
            nr = self.n - 1
        if nr < ql or self.minv[idx] > 0 or self.maxv[idx] < 0:
            return -1
        if nl == nr:
            return nl
        self._push(idx)
        mid = (nl + nr) // 2
        res = self.find_zero(ql, idx * 2 + 1, mid + 1, nr)
        if res != -1:
            return res
        return self.find_zero(ql, idx * 2, nl, mid)


class Solution:
    def longestBalanced(self, nums: List[int]) -> int:
        """
        3721. Longest Balanced Subarray II
        Time: O(n log n)
        Space: O(n)
        """
        n = len(nums)
        pos = defaultdict(deque)

        for i, v in enumerate(nums):
            pos[v].append(i)

        st = SegmentTree(n)

        for v, dq in pos.items():
            sign = 1 if v % 2 else -1
            st.range_add(dq[0], n - 1, sign)

        ans = 0

        for l in range(n):
            r = st.find_zero(l)
            if r != -1:
                ans = max(ans, r - l + 1)

            v = nums[l]
            sign = 1 if v % 2 else -1
            dq = pos[v]
            dq.popleft()
            nxt = dq[0] if dq else n
            st.range_add(l, nxt - 1, -sign)

        return ans
