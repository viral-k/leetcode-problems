from typing import List
from collections import defaultdict


class Solution:
    def largestOverlap(self, img1: List[List[int]], img2: List[List[int]]) -> int:
        """
        835. Image Overlap
        Time: O(k1 * k2)
        Space: O(n^2)
        """
        n = len(img1)
        ones1 = [(r, c) for r in range(n) for c in range(n) if img1[r][c]]
        ones2 = [(r, c) for r in range(n) for c in range(n) if img2[r][c]]

        # each (1, 1) pair votes for the one translation that aligns them
        votes = defaultdict(int)
        for r1, c1 in ones1:
            for r2, c2 in ones2:
                votes[(r2 - r1, c2 - c1)] += 1

        return max(votes.values(), default=0)
