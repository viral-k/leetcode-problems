from collections import Counter


class Solution:
    def rearrangeCharacters(self, s: str, target: str) -> int:
        """
        2287. Rearrange Characters to Make Target String
        Time: O(|s| + |target|)
        Space: O(1)
        """
        s_counts = Counter(s)
        target_counts = Counter(target)

        return min(s_counts[ch] // need for ch, need in target_counts.items())
