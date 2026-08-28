class Solution:
    def smallestPalindrome(self, s: str, target: str) -> str:
        """
        3734. Lexicographically Smallest Palindromic Permutation Greater Than Target
        Time: O(26 * n)
        Space: O(n)
        """
        n = len(s)
        cnt = [0] * 26
        for ch in s:
            cnt[ord(ch) - 97] += 1

        # A palindrome needs at most one odd-count letter, matching n's parity.
        odd = [i for i in range(26) if cnt[i] % 2]
        if len(odd) > 1:
            return ""
        if (n % 2 == 0) != (len(odd) == 0):
            return ""
        mid = chr(97 + odd[0]) if odd else ""

        half = [c // 2 for c in cnt]
        h = n // 2
        tpre = target[:h]

        def build(left: str) -> str:
            return left + mid + left[::-1]

        # Case 1: the left half ties with target's prefix -> a single candidate.
        need = [0] * 26
        for ch in tpre:
            need[ord(ch) - 97] += 1
        if all(need[i] <= half[i] for i in range(26)):
            candidate = build(tpre)
            if candidate > target:
                return candidate

        # Case 2: smallest permutation of the half-multiset strictly above tpre.
        counts = half[:]
        matched = 0
        while matched < h and counts[ord(tpre[matched]) - 97] > 0:
            counts[ord(tpre[matched]) - 97] -= 1
            matched += 1

        # A longer shared prefix gives a smaller left half, so search downward.
        for p in range(matched, -1, -1):
            while matched > p:
                matched -= 1
                counts[ord(tpre[matched]) - 97] += 1
            if p >= h:
                continue
            for c in range(ord(tpre[p]) - 97 + 1, 26):
                if counts[c] > 0:
                    counts[c] -= 1
                    rest = "".join(chr(97 + j) * counts[j] for j in range(26))
                    return build(tpre[:p] + chr(97 + c) + rest)

        return ""
