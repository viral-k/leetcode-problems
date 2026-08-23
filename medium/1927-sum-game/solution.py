class Solution:
    def sumGame(self, num: str) -> bool:
        """
        1927. Sum Game
        Time: O(n)
        Space: O(1)
        """
        n = len(num)
        half = n // 2

        sum_left = sum_right = 0
        q_left = q_right = 0
        for i, ch in enumerate(num):
            if i < half:
                if ch == "?":
                    q_left += 1
                else:
                    sum_left += int(ch)
            else:
                if ch == "?":
                    q_right += 1
                else:
                    sum_right += int(ch)

        # Odd number of blanks: Alice moves last and can always break equality.
        if (q_left + q_right) % 2 == 1:
            return True

        # Surplus blanks on one side are worth 9 per pair under optimal play.
        return sum_left - sum_right != 9 * (q_right - q_left) // 2
