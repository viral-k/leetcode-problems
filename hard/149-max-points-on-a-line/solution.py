from collections import defaultdict
from math import gcd
from typing import List


class Solution:
    def maxPoints(self, points: List[List[int]]) -> int:
        """
        149. Max Points on a Line
        Time: O(n^2)
        Space: O(n)
        """
        n = len(points)
        if n < 3:
            return n

        best = 2
        for i in range(n):
            x1, y1 = points[i]
            slopes = defaultdict(int)
            for j in range(i + 1, n):
                x2, y2 = points[j]
                dx = x2 - x1
                dy = y2 - y1

                # canonical direction: reduce by gcd, then force dx > 0
                # (or dy = 1 when vertical) so opposite directions agree
                g = gcd(abs(dx), abs(dy))
                dx //= g
                dy //= g
                if dx < 0:
                    dx, dy = -dx, -dy
                elif dx == 0:
                    dy = 1

                slopes[(dx, dy)] += 1

            if slopes:
                best = max(best, 1 + max(slopes.values()))

        return best
