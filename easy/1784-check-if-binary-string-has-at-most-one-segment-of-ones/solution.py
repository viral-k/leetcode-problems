class Solution:
    def checkOnesSegment(self, s: str) -> bool:
        """
        1784. Check if Binary String Has at Most One Segment of Ones
        Time: O(n)
        Space: O(1)
        """
        return "01" not in s
