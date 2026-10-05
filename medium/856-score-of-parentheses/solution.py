class Solution:
    def scoreOfParentheses(self, s: str) -> int:
        """
        856. Score of Parentheses
        Time: O(n)
        Space: O(1)
        """
        total = 0
        depth = 0

        for i, ch in enumerate(s):
            if ch == "(":
                depth += 1
            else:
                depth -= 1
                # a "()" core at depth d contributes 2^(d-1); every enclosing
                # pair doubled it, and nothing else contributes anything
                if s[i - 1] == "(":
                    total += 1 << depth

        return total
