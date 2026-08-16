from typing import List


class Solution:
    def stoneGameIX(self, stones: List[int]) -> bool:
        """
        2029. Stone Game IX
        Time: O(n)
        Space: O(1)
        """
        count = [0, 0, 0]
        for s in stones:
            count[s % 3] += 1
        c0, c1, c2 = count

        if c0 % 2 == 0:
            # zeros cancel in turn order: Alice needs both residues to start a chain
            return c1 >= 1 and c2 >= 1
        # one leftover pass flips the race; need a gap of at least 3
        return abs(c1 - c2) > 2
