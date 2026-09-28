class Solution:
    def maxDepth(self, s: str) -> int:
        """
        1614. Maximum Nesting Depth of the Parentheses
        Time: O(n)
        Space: O(1)
        """
        depth = 0
        best = 0
        for ch in s:
            if ch == "(":
                depth += 1
                if depth > best:
                    best = depth
            elif ch == ")":
                depth -= 1
        return best
