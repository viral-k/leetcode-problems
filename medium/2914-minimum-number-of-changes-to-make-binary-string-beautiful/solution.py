class Solution:
    def minChanges(self, s: str) -> int:
        """
        2914. Minimum Number of Changes to Make Binary String Beautiful
        Time: O(n)
        Space: O(1)
        """
        # Beautiful <=> every aligned pair (s[2i], s[2i+1]) is equal, and each
        # mismatched pair costs exactly one change.
        return sum(s[i] != s[i + 1] for i in range(0, len(s), 2))
