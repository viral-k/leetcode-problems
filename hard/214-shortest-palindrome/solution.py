class Solution:
    def shortestPalindrome(self, s: str) -> str:
        """
        214. Shortest Palindrome
        Time: O(n)
        Space: O(n)
        """
        if not s:
            return ""

        # the '#' is absent from the alphabet, so no border can straddle it
        # and pi[-1] is capped at len(s)
        t = s + "#" + s[::-1]
        n = len(t)

        # pi[i] = longest proper prefix of t[:i+1] that is also its suffix
        pi = [0] * n
        k = 0
        for i in range(1, n):
            while k and t[i] != t[k]:
                k = pi[k - 1]
            if t[i] == t[k]:
                k += 1
            pi[i] = k

        # pi[-1] = longest prefix of s that is also a suffix of reversed s,
        # i.e. the longest palindromic prefix of s
        longest_pal_prefix = pi[-1]
        return s[longest_pal_prefix:][::-1] + s
