class Solution:
    def longestValidParentheses(self, s: str) -> int:
        """
        32. Longest Valid Parentheses
        Time: O(n)
        Space: O(n)
        """
        best = 0
        stack = [-1]  # sentinel boundary before any valid run

        for i, ch in enumerate(s):
            if ch == "(":
                stack.append(i)
            else:
                stack.pop()
                if not stack:
                    stack.append(i)  # unmatched ')', new boundary
                else:
                    best = max(best, i - stack[-1])

        return best
