class Solution:
    def rotateString(self, s: str, goal: str) -> bool:
        """
        796. Rotate String
        Time: O(n)
        Space: O(n)
        """
        if len(s) != len(goal):
            return False

        pattern = goal
        text = s + s
        lps = self._build_lps(pattern)
        matched = 0

        for char in text:
            while matched > 0 and char != pattern[matched]:
                matched = lps[matched - 1]

            if char == pattern[matched]:
                matched += 1

            if matched == len(pattern):
                return True

        return False

    def _build_lps(self, pattern: str) -> list[int]:
        lps = [0] * len(pattern)
        length = 0

        for i in range(1, len(pattern)):
            while length > 0 and pattern[i] != pattern[length]:
                length = lps[length - 1]

            if pattern[i] == pattern[length]:
                length += 1
                lps[i] = length

        return lps
