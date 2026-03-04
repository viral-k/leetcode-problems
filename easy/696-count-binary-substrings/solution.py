class Solution:
    def countBinarySubstrings(self, s: str) -> int:
        """
        696. Count Binary Substrings
        Time: O(n)
        Space: O(1)
        """
        prev = 0
        curr = 1
        ans = 0

        for i in range(1, len(s)):
            if s[i] == s[i - 1]:
                curr += 1
            else:
                ans += min(prev, curr)
                prev = curr
                curr = 1

        ans += min(prev, curr)
        return ans
