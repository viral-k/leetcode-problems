class Solution:
    def numberOfSubstrings(self, s: str) -> int:
        """
        1358. Number of Substrings Containing All Three Characters
        Time: O(n)
        Space: O(1)
        """
        last = [-1, -1, -1]  # last index of a, b, c
        ans = 0
        for i, ch in enumerate(s):
            last[ord(ch) - ord("a")] = i
            ans += min(last) + 1  # min(last) = -1 until all three seen
        return ans
