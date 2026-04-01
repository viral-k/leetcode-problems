from typing import List


class Solution:
    def survivedRobotsHealths(self, positions: List[int], healths: List[int], directions: str) -> List[int]:
        """
        2751. Robot Collisions
        Time: O(n log n)
        Space: O(n)
        """
        n = len(positions)

        robots = sorted([(positions[i], i) for i in range(n)])

        stack = []

        for _, i in robots:
            if directions[i] == 'R':
                stack.append(i)
            else:
                while stack and healths[i] > 0:
                    j = stack[-1]

                    if healths[j] < healths[i]:
                        healths[i] -= 1
                        healths[j] = 0
                        stack.pop()
                    elif healths[j] > healths[i]:
                        healths[j] -= 1
                        healths[i] = 0
                        break
                    else:
                        healths[j] = 0
                        healths[i] = 0
                        stack.pop()
                        break

        return [healths[i] for i in range(n) if healths[i] > 0]
