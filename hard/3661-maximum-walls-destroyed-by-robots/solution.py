from bisect import bisect_left, bisect_right
from typing import List


class Solution:
    def maxWallsDestroyed(self, robots: List[int], distance: List[int], walls: List[int]) -> int:
        """
        3661. Maximum Walls Destroyed by Robots
        Time: O(n log n + m log m)
        Space: O(n)
        """
        n = len(robots)
        robots_with_d = sorted(zip(robots, distance))
        robots = [r for r, _ in robots_with_d]
        dist = {r: d for r, d in robots_with_d}
        walls.sort()

        left_l = [0] * n
        left_r = [0] * n
        right_l = [0] * n
        right_r = [0] * n

        for i in range(n):
            p = robots[i]
            d = dist[p]

            L = p - d
            if i > 0:
                L = max(L, robots[i - 1] + 1)

            left_l[i] = bisect_left(walls, L)
            left_r[i] = bisect_right(walls, p) - 1

            R = p + d
            if i < n - 1:
                R = min(R, robots[i + 1] - 1)

            right_l[i] = bisect_left(walls, p)
            right_r[i] = bisect_right(walls, R) - 1

        def count(l, r):
            return max(0, r - l + 1)

        left = [count(left_l[i], left_r[i]) for i in range(n)]
        right = [count(right_l[i], right_r[i]) for i in range(n)]

        overlap = [0] * n
        for i in range(1, n):
            l = max(right_l[i - 1], left_l[i])
            r = min(right_r[i - 1], left_r[i])
            overlap[i] = max(0, r - l + 1)

        sub_left = left[0]
        sub_right = right[0]

        for i in range(1, n):
            current_left = max(
                sub_left + left[i],
                sub_right + left[i] - overlap[i]
            )

            current_right = max(
                sub_left + right[i],
                sub_right + right[i]
            )

            sub_left, sub_right = current_left, current_right

        return max(sub_left, sub_right)
