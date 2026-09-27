class Solution:
    def reverseParentheses(self, s: str) -> str:
        """
        1190. Reverse Substrings Between Each Pair of Parentheses
        Time: O(n)
        Space: O(n)
        """
        n = len(s)
        pair = [0] * n
        stack = []
        for i, ch in enumerate(s):
            if ch == "(":
                stack.append(i)
            elif ch == ")":
                j = stack.pop()
                pair[i] = j
                pair[j] = i

        # each bracket teleports to its partner and flips the reading
        # direction, which is exactly what reversing that group does
        out = []
        i = 0
        step = 1
        while 0 <= i < n:
            if s[i] == "(" or s[i] == ")":
                i = pair[i]
                step = -step
            else:
                out.append(s[i])
            i += step

        return "".join(out)
