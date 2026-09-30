from typing import List


class Solution:
    def maxDepthAfterSplit(self, seq: str) -> List[int]:
        """
        1111. Maximum Nesting Depth of Two Valid Parentheses Strings
        Time: O(n)
        Space: O(1) beyond the output
        """
        answer = [0] * len(seq)
        depth = 0

        for i, ch in enumerate(seq):
            if ch == "(":
                depth += 1
                answer[i] = depth % 2
            else:
                # read before the decrement so a pair shares its depth
                answer[i] = depth % 2
                depth -= 1

        return answer
