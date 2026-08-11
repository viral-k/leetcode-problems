class Solution:
    def winnerSquareGame(self, n: int) -> bool:
        """
        1510. Stone Game IV
        Time: O(n * sqrt(n))
        Space: O(n)
        """
        # win[i] = True if the player to move with i stones wins
        win = [False] * (n + 1)
        for i in range(1, n + 1):
            k = 1
            while k * k <= i:
                if not win[i - k * k]:
                    win[i] = True  # leave the opponent in a losing position
                    break
                k += 1
        return win[n]
