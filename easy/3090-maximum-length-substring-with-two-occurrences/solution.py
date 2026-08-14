class Solution:
    def maximumLengthSubstring(self, s: str) -> int:
        """
        3090. Maximum Length Substring With Two Occurrences
        Time: O(n)
        Space: O(26)
        """
        count = [0] * 26
        left = 0
        best = 0

        for r, ch in enumerate(s):
            c = ord(ch) - 97
            count[c] += 1
            # only the just-added character can exceed the limit
            while count[c] > 2:
                count[ord(s[left]) - 97] -= 1
                left += 1
            best = max(best, r - left + 1)

        return best
