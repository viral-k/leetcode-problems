from typing import List


class Solution:
    def generateParenthesis(self, n: int) -> List[str]:
        """
        22. Generate Parentheses
        Time: O(C(n) * n) where C(n) is the nth Catalan number
        Space: O(n) excluding the output
        """
        result = []
        buf = []

        def backtrack(open_count: int, close_count: int) -> None:
            if len(buf) == 2 * n:
                result.append("".join(buf))
                return
            # '(' first so the output comes out lexicographically sorted
            if open_count < n:
                buf.append("(")
                backtrack(open_count + 1, close_count)
                buf.pop()
            if close_count < open_count:
                buf.append(")")
                backtrack(open_count, close_count + 1)
                buf.pop()

        backtrack(0, 0)
        return result
