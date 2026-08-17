from typing import List


class Solution:
    def stoneGameVI(self, aliceValues: List[int], bobValues: List[int]) -> int:
        """
        1686. Stone Game VI
        Time: O(n log n)
        Space: O(n)
        """
        n = len(aliceValues)
        # A stone's importance is the swing it causes: own gain + opponent's denial.
        order = sorted(range(n), key=lambda i: -(aliceValues[i] + bobValues[i]))

        alice = sum(aliceValues[order[i]] for i in range(0, n, 2))
        bob = sum(bobValues[order[i]] for i in range(1, n, 2))

        if alice > bob:
            return 1
        if alice < bob:
            return -1
        return 0
