class Solution:
    def isValid(self, s: str) -> bool:
        """
        20. Valid Parentheses
        Time: O(n)
        Space: O(n)
        """
        close_to_open = {")": "(", "]": "[", "}": "{"}
        stack = []

        for ch in s:
            if ch in close_to_open:
                if not stack or stack.pop() != close_to_open[ch]:
                    return False
            else:
                stack.append(ch)

        return not stack
