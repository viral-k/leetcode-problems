class Solution:
    def minCut(self, s: str) -> int:
        """
        132. Palindrome Partitioning II
        Time: O(n^2)
        Space: O(n^2)
        """
        n = len(s)
        is_pal = [bytearray(n) for _ in range(n)]

        # expand around each of the 2n-1 centers; every true cell written once
        for center in range(2 * n - 1):
            left = center // 2
            right = left + center % 2
            while left >= 0 and right < n and s[left] == s[right]:
                is_pal[left][right] = 1
                left -= 1
                right += 1

        INF = float("inf")
        # cuts[i] = min cuts for s[i:]; the -1 sentinel makes a palindromic
        # suffix reaching the end cost 1 + (-1) = 0
        cuts = [INF] * (n + 1)
        cuts[n] = -1

        for i in range(n - 1, -1, -1):
            row = is_pal[i]
            best = INF
            for j in range(i, n):
                if row[j] and cuts[j + 1] + 1 < best:
                    best = cuts[j + 1] + 1
            cuts[i] = best

        return cuts[0]
