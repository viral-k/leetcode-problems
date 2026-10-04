class Solution:
    def checkValidString(self, s: str) -> bool:
        """
        678. Valid Parenthesis String
        Time: O(n)
        Space: O(1)
        """
        # [lo, hi] = reachable open-bracket counts for the prefix so far
        lo = hi = 0

        for ch in s:
            if ch == "(":
                lo += 1
                hi += 1
            elif ch == ")":
                lo -= 1
                hi -= 1
            else:  # '*' can be ')', '(' or empty
                lo -= 1
                hi += 1

            if hi < 0:
                return False  # more ')' than any reading can match
            if lo < 0:
                lo = 0  # treat the wildcard as empty instead

        return lo == 0
