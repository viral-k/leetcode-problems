class Solution:
    def longestBalanced(self, s: str) -> int:
        """
        3713. Longest Balanced Substring I
        Time: O(n²)
        Space: O(1)
        """
        n = len(s)
        ans = 0

        for i in range(n):
            freq = [0] * 26
            distinct = 0
            max_freq = 0

            for j in range(i, n):
                idx = ord(s[j]) - ord('a')
                if freq[idx] == 0:
                    distinct += 1
                freq[idx] += 1
                max_freq = max(max_freq, freq[idx])

                length = j - i + 1
                if distinct * max_freq == length:
                    ans = max(ans, length)

        return ans
