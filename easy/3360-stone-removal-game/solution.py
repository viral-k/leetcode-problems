class Solution:
    def canAliceWin(self, n: int) -> bool:
        """
        3360. Stone Removal Game
        Time: O(1)
        Space: O(1)
        """
        # The moves are forced: 10, 9, 8, ... Whoever can't match theirs loses.
        take = 10
        moves = 0
        while n >= take:
            n -= take
            take -= 1
            moves += 1
        return moves % 2 == 1
