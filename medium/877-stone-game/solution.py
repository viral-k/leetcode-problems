from typing import List


class Solution:
    def stoneGame(self, piles: List[int]) -> bool:
        """
        877. Stone Game
        Time: O(1)
        Space: O(1)
        """
        # Even pile count + odd total => the first player can always win
        # (commit to all even-indexed or all odd-indexed piles, take the larger group).
        return True
