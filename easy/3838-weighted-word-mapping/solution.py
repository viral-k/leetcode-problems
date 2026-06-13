from typing import List


class Solution:
    def weightedWordMapping(self, words: List[str], weights: List[int]) -> str:
        """
        3838. Weighted Word Mapping
        Time: O(L) over all characters
        Space: O(w) for the output
        """
        result = []

        for word in words:
            total = sum(weights[ord(ch) - ord('a')] for ch in word)
            r = total % 26
            result.append(chr(ord('z') - r))

        return "".join(result)
