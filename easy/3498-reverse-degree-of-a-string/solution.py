class Solution:
    def reverseDegree(self, s: str) -> int:
        """
        3498. Reverse Degree of a String
        Time: O(n)
        Space: O(1)
        """
        total = 0
        for i, ch in enumerate(s):
            weight = 26 - (ord(ch) - ord("a"))
            total += weight * (i + 1)
        return total
