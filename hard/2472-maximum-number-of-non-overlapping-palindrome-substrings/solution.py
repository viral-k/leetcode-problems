class Solution:
    def maxPalindromes(self, s: str, k: int) -> int:
        """
        2472. Maximum Number of Non-overlapping Palindrome Substrings
        Time: O(n * k)
        Space: O(1)
        """
        n = len(s)

        def is_pal(lo: int, hi: int) -> bool:
            # inclusive bounds
            while lo < hi:
                if s[lo] != s[hi]:
                    return False
                lo += 1
                hi -= 1
            return True

        count = 0
        i = 0
        while i + k <= n:
            # any palindrome of length >= k contains one of length k or k+1,
            # so those are the only candidates; take the earliest-ending one
            if is_pal(i, i + k - 1):
                count += 1
                i += k
            elif i + k < n and is_pal(i, i + k):
                count += 1
                i += k + 1
            else:
                i += 1

        return count
