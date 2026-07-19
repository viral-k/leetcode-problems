class Solution:
    def smallestSubsequence(self, s: str) -> str:
        """
        1081. Smallest Subsequence of Distinct Characters
        Time: O(n)
        Space: O(26)
        """
        last = {c: i for i, c in enumerate(s)}  # last occurrence of each char
        stack = []
        in_stack = set()

        for i, c in enumerate(s):
            if c in in_stack:
                continue
            # drop bigger characters that we can still re-add later
            while stack and stack[-1] > c and last[stack[-1]] > i:
                in_stack.remove(stack.pop())
            stack.append(c)
            in_stack.add(c)

        return "".join(stack)
