from typing import List


class Solution:
    def numOfStrings(self, patterns: List[str], word: str) -> int:
        """
        1967. Number of Strings That Appear as Substrings in Word
        Time: O(n * |word| * |pattern|)
        Space: O(1)
        """
        return sum(1 for p in patterns if p in word)
