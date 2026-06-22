from collections import Counter


class Solution:
    def maxNumberOfBalloons(self, text: str) -> int:
        """
        1189. Maximum Number of Balloons
        Time: O(n)
        Space: O(1)
        """
        counts = Counter(text)
        return min(
            counts["b"],
            counts["a"],
            counts["l"] // 2,
            counts["o"] // 2,
            counts["n"],
        )
