from typing import List


class Solution:
    def robotSim(self, commands: List[int], obstacles: List[List[int]]) -> int:
        """
        874. Walking Robot Simulation
        Time: O(n + m) where n = total steps, m = obstacles
        Space: O(m)
        """
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        obstacle_set = {(x, y) for x, y in obstacles}

        x, y = 0, 0
        d = 0
        max_dist = 0

        for cmd in commands:
            if cmd == -2:
                d = (d + 3) % 4
            elif cmd == -1:
                d = (d + 1) % 4
            else:
                dx, dy = directions[d]
                for _ in range(cmd):
                    nx, ny = x + dx, y + dy
                    if (nx, ny) in obstacle_set:
                        break
                    x, y = nx, ny
                    max_dist = max(max_dist, x * x + y * y)

        return max_dist
