class Solution:
    def shortestBeautifulSubstring(self, s: str, k: int) -> str:
        """
        2904. Shortest and Lexicographically Smallest Beautiful String
        Time: O(n^2)
        Space: O(n)
        """
        # A beautiful substring can always be trimmed to start and end on a '1',
        # so only windows of k consecutive ones matter.
        ones = [i for i, ch in enumerate(s) if ch == "1"]
        if len(ones) < k:
            return ""

        best = ""
        for i in range(len(ones) - k + 1):
            start, end = ones[i], ones[i + k - 1]
            candidate = s[start:end + 1]
            if not best or len(candidate) < len(best) or (
                len(candidate) == len(best) and candidate < best
            ):
                best = candidate
        return best
