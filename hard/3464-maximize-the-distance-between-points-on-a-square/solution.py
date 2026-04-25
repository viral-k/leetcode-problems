from typing import List
from bisect import bisect_left


class Solution:
    def maxDistance(self, side: int, points: List[List[int]], k: int) -> int:
        """
        3464. Maximize the Distance Between Points on a Square
        Time: O(n * k * log n * log(perimeter/k))
        Space: O(n)
        """
        perimeter = 4 * side

        def to_perimeter_pos(x: int, y: int) -> int:
            if y == 0:
                return x
            elif x == side:
                return side + y
            elif y == side:
                return 2 * side + (side - x)
            else:
                return 3 * side + (side - y)

        positions = sorted(to_perimeter_pos(x, y) for x, y in points)
        n = len(positions)

        # Double the array for cyclic handling
        extended = positions + [p + perimeter for p in positions]

        def canAchieve(d: int) -> bool:
            for start in range(n):
                count = 1
                last_idx = start

                for _ in range(k - 1):
                    target = extended[last_idx] + d
                    next_idx = bisect_left(extended, target, last_idx + 1, start + n)

                    if next_idx >= start + n:
                        break

                    count += 1
                    last_idx = next_idx

                if count == k:
                    wrap_dist = extended[start + n] - extended[last_idx]
                    if wrap_dist >= d:
                        return True

            return False

        lo, hi = 1, perimeter // k
        ans = 1

        while lo <= hi:
            mid = (lo + hi) // 2
            if canAchieve(mid):
                ans = mid
                lo = mid + 1
            else:
                hi = mid - 1

        return ans
