from collections import Counter


class Solution:
    def smallestPalindrome(self, s: str, k: int) -> str:
        """
        3518. Smallest Palindromic Rearrangement II
        Time: O(L * 26)  (capped permutation counts short-circuit)
        Space: O(26 + n)
        """
        CAP = 10**6 + 1  # strictly greater than the maximum possible k

        cnt = Counter(s)
        counts = [0] * 26
        middle = ""
        for ch, c in cnt.items():
            counts[ord(ch) - 97] = c // 2
            if c % 2 == 1:
                middle = ch

        def comb_capped(n: int, r: int) -> int:
            # C(n, r) capped at CAP, with early exit
            if r < 0 or r > n:
                return 0
            r = min(r, n - r)
            c = 1
            for i in range(1, r + 1):
                c = c * (n - r + i) // i
                if c >= CAP:
                    return CAP
            return c

        def perms_capped() -> int:
            # distinct permutations of the current `counts` multiset, capped
            result = 1
            n = sum(counts)
            for c in counts:
                if c == 0:
                    continue
                result *= comb_capped(n, c)
                if result >= CAP:
                    return CAP
                n -= c
            return result

        # Feasibility: not enough distinct palindromes.
        if perms_capped() < k:
            return ""

        # Build the left half via combinatorial ranking.
        half_len = sum(counts)
        left = []
        for _ in range(half_len):
            for ci in range(26):
                if counts[ci] == 0:
                    continue
                counts[ci] -= 1
                w = perms_capped()
                if k <= w:
                    left.append(chr(97 + ci))
                    break
                k -= w
                counts[ci] += 1

        left_half = "".join(left)
        return left_half + middle + left_half[::-1]
