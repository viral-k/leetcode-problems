class Solution:
    def distinctSubseqII(self, s: str) -> int:
        """
        940. Distinct Subsequences II
        Time: O(n)
        Space: O(26)
        """
        MOD = 10**9 + 7

        # ending[c] = distinct subsequences ending in character c
        ending = [0] * 26
        total = 0

        for ch in s:
            c = ord(ch) - 97
            # append c to every existing subsequence, plus "c" alone
            updated = (total + 1) % MOD
            # overwrite the bucket: earlier duplicates are regenerated here
            total = (total - ending[c] + updated) % MOD
            ending[c] = updated

        return total % MOD
