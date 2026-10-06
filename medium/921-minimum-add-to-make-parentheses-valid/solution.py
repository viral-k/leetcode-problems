class Solution:
    def minAddToMakeValid(self, s: str) -> int:
        """
        921. Minimum Add to Make Parentheses Valid
        Time: O(n)
        Space: O(1)
        """
        open_count = 0  # unmatched '(' seen so far
        adds = 0        # ')' that had nothing to pair with

        for ch in s:
            if ch == "(":
                open_count += 1
            elif open_count > 0:
                open_count -= 1
            else:
                adds += 1

        # leftover openers each need a ')' appended
        return adds + open_count
