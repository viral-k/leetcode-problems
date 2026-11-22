class Solution:
    def checkString(self, s: str) -> bool:
        """
        2124. Check if All A's Appears Before All B's
        Time: O(n)
        Space: O(1)
        """
        # Valid strings look like a...ab...b; any violation contains "ba".
        return "ba" not in s
