class Solution:
    def smallestPermutation(self, s: str, target: str) -> str:
        """
        3720. Lexicographically Smallest Permutation Greater Than Target
        Time: O(26 * n)
        Space: O(n)
        """
        n = len(s)
        counts = [0] * 26
        for ch in s:
            counts[ord(ch) - 97] += 1

        # Longest prefix of target that s's letters can spell.
        matched = 0
        while matched < n and counts[ord(target[matched]) - 97] > 0:
            counts[ord(target[matched]) - 97] -= 1
            matched += 1

        # Prefer the longest shared prefix: deviating later gives a smaller result.
        for p in range(matched, -1, -1):
            # Roll characters back into the pool until counts match a prefix of length p.
            while matched > p:
                matched -= 1
                counts[ord(target[matched]) - 97] += 1

            if p >= n:
                continue  # a full match is equal, not strictly greater

            # Smallest available letter strictly greater than target[p].
            for c in range(ord(target[p]) - 97 + 1, 26):
                if counts[c] > 0:
                    counts[c] -= 1
                    rest = "".join(chr(97 + j) * counts[j] for j in range(26))
                    return target[:p] + chr(97 + c) + rest

        return ""
