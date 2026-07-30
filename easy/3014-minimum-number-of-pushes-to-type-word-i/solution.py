class Solution:
    def minimumPushes(self, word: str) -> int:
        """
        3014. Minimum Number of Pushes to Type Word I
        Time: O(n)
        Space: O(1)
        """
        # Distinct letters: the i-th letter (0-based) costs i // 8 + 1 pushes.
        return sum(i // 8 + 1 for i in range(len(word)))
