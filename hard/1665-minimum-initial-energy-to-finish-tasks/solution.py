from typing import List


class Solution:
    def minimumEffort(self, tasks: List[List[int]]) -> int:
        """
        1665. Minimum Initial Energy to Finish Tasks
        Time: O(n log n)
        Space: O(1)
        """
        tasks.sort(key=lambda task: task[1] - task[0], reverse=True)

        initial = 0
        current = 0

        for actual, minimum in tasks:
            if current < minimum:
                needed = minimum - current
                initial += needed
                current += needed

            current -= actual

        return initial
