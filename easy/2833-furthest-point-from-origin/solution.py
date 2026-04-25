class Solution:
    def furthestDistanceFromOrigin(self, moves: str) -> int:
        """
        2833. Furthest Point From Origin
        Time: O(n)
        Space: O(1)
        """
        left = moves.count('L')
        right = moves.count('R')
        underscore = moves.count('_')

        return abs(left - right) + underscore
