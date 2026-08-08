from typing import List


class Solution:
    def validSequence(self, word1: str, word2: str) -> List[int]:
        """
        3302. Find the Lexicographically Smallest Valid Sequence
        Time: O(n)
        Space: O(n)
        """
        n, m = len(word1), len(word2)

        # f[i] = # of trailing chars of word2 matchable exactly by word1[i:]
        f = [0] * (n + 1)
        k = 0
        for i in range(n - 1, -1, -1):
            if k < m and word1[i] == word2[m - 1 - k]:
                k += 1
            f[i] = k

        res = []
        j = 0
        changed = False
        i = 0
        while i < n and j < m:
            if word1[i] == word2[j]:
                res.append(i)
                j += 1
                i += 1
            elif not changed and f[i + 1] >= m - j - 1:
                # spend the single change here; the rest still matches exactly
                res.append(i)
                j += 1
                i += 1
                changed = True
            else:
                i += 1

        return res if j == m else []
