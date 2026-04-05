class Solution:
    def judgeCircle(self, moves: str) -> bool:
        """
        657. Robot Return to Origin
        Time: O(n)
        Space: O(1)
        """
        x = y = 0

        for m in moves:
            if m == 'U':
                y += 1
            elif m == 'D':
                y -= 1
            elif m == 'R':
                x += 1
            else:
                x -= 1

        return x == 0 and y == 0
