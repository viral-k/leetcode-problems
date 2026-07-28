from collections import Counter


class Solution:
    def smallestPalindrome(self, s: str) -> str:
        """
        3517. Smallest Palindromic Rearrangement I
        Time: O(n)
        Space: O(n)
        """
        cnt = Counter(s)

        left = []
        middle = ""
        for ch in sorted(cnt):
            left.append(ch * (cnt[ch] // 2))
            if cnt[ch] % 2 == 1:
                middle = ch  # the single odd character sits in the center

        left_half = "".join(left)
        return left_half + middle + left_half[::-1]
