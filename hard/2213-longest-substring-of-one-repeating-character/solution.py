from typing import List


class Solution:
    def longestRepeating(self, s: str, queryCharacters: str, queryIndices: List[int]) -> List[int]:
        """
        2213. Longest Substring of One Repeating Character
        Time: O((n + k) log n)
        Space: O(n)
        """
        n = len(s)
        size = 1
        while size < n:
            size <<= 1

        # Per-node: prefix run, suffix run, best run, edge chars, segment length.
        pre = [0] * (2 * size)
        suf = [0] * (2 * size)
        best = [0] * (2 * size)
        lc = [0] * (2 * size)
        rc = [0] * (2 * size)
        ln = [0] * (2 * size)

        def pull(i: int) -> None:
            l, r = 2 * i, 2 * i + 1
            if ln[l] == 0:  # padding child acts as identity
                pre[i], suf[i], best[i] = pre[r], suf[r], best[r]
                lc[i], rc[i], ln[i] = lc[r], rc[r], ln[r]
                return
            if ln[r] == 0:
                pre[i], suf[i], best[i] = pre[l], suf[l], best[l]
                lc[i], rc[i], ln[i] = lc[l], rc[l], ln[l]
                return
            ln[i] = ln[l] + ln[r]
            lc[i], rc[i] = lc[l], rc[r]
            join = rc[l] == lc[r]
            b = best[l] if best[l] > best[r] else best[r]
            if join and suf[l] + pre[r] > b:
                b = suf[l] + pre[r]  # run crossing the boundary
            best[i] = b
            # a child that is entirely one character lets the run continue
            pre[i] = pre[l] + (pre[r] if (join and pre[l] == ln[l]) else 0)
            suf[i] = suf[r] + (suf[l] if (join and suf[r] == ln[r]) else 0)

        for i, ch in enumerate(s):
            j = size + i
            pre[j] = suf[j] = best[j] = ln[j] = 1
            lc[j] = rc[j] = ord(ch)
        for i in range(size - 1, 0, -1):
            pull(i)

        result = []
        for ch, idx in zip(queryCharacters, queryIndices):
            j = size + idx
            lc[j] = rc[j] = ord(ch)
            j >>= 1
            while j:
                pull(j)
                j >>= 1
            result.append(best[1])
        return result
