from functools import lru_cache


class Solution:
    def isScramble(self, s1: str, s2: str) -> bool:
        """
        87. Scramble String
        Time: O(n^4)
        Space: O(n^3)
        """
        n = len(s1)
        if n != len(s2):
            return False

        @lru_cache(maxsize=None)
        def solve(i: int, j: int, length: int) -> bool:
            # can s1[i:i+length] scramble into s2[j:j+length]?
            a = s1[i:i + length]
            b = s2[j:j + length]
            if a == b:
                return True
            if sorted(a) != sorted(b):
                return False  # different letters: no split can work

            for k in range(1, length):
                # halves kept in order
                if solve(i, j, k) and solve(i + k, j + k, length - k):
                    return True
                # halves swapped: s1's prefix lands on s2's suffix
                if solve(i, j + length - k, k) and solve(i + k, j, length - k):
                    return True
            return False

        result = solve(0, 0, n)
        solve.cache_clear()
        return result
