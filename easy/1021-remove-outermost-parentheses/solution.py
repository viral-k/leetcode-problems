class Solution:
    def removeOuterParentheses(self, s: str) -> str:
        """
        1021. Remove Outermost Parentheses
        Time: O(n)
        Space: O(n) for the output, O(1) beyond it
        """
        out = []
        depth = 0

        for ch in s:
            if ch == "(":
                # outermost when the depth before it is 0
                if depth > 0:
                    out.append(ch)
                depth += 1
            else:
                depth -= 1
                # outermost when the depth after it is 0
                if depth > 0:
                    out.append(ch)

        return "".join(out)
