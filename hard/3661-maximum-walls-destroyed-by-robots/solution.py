import bisect
from typing import List


class Solution:
    def maxWallsDestroyed(self, robots: List[int], distance: List[int], walls: List[int]) -> int:
        """
        3661. Maximum Walls Destroyed by Robots
        Time: O(n log n + m log m)
        Space: O(n + m)
        """
        n = len(robots)
        robots = sorted(zip(robots, distance))
        walls.sort()

        positions = [r for r, _ in robots]

        intervals = []

        for i, (pos, dist) in enumerate(robots):
            left_block = positions[i - 1] if i > 0 else -10**18
            L = max(pos - dist, left_block)
            R = pos
            intervals.append((L, R))

            right_block = positions[i + 1] if i < n - 1 else 10**18
            L = pos
            R = min(pos + dist, right_block)
            intervals.append((L, R))

        intervals.sort(key=lambda x: x[1])

        used = set()
        res = 0

        for L, R in intervals:
            l = bisect.bisect_left(walls, L)
            r = bisect.bisect_right(walls, R)

            for i in range(l, r):
                if walls[i] not in used:
                    used.add(walls[i])
                    res += 1

        return res
