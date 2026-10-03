class Solution:
    def longestValidParentheses(self, s: str) -> int:
        """
        32. Longest Valid Parentheses
        Time: O(n)
        Space: O(1)
        """
        best = 0

        # left to right: a prefix with more ')' than '(' can never recover,
        # so reset there; equality means the scanned stretch is balanced
        open_count = close_count = 0
        for ch in s:
            if ch == "(":
                open_count += 1
            else:
                close_count += 1
            if open_count == close_count:
                best = max(best, 2 * close_count)
            elif close_count > open_count:
                open_count = close_count = 0

        # right to left catches runs with leftover unmatched '(' like "(()"
        open_count = close_count = 0
        for ch in reversed(s):
            if ch == "(":
                open_count += 1
            else:
                close_count += 1
            if open_count == close_count:
                best = max(best, 2 * open_count)
            elif open_count > close_count:
                open_count = close_count = 0

        return best
