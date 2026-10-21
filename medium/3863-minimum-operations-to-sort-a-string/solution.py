class Solution:
    def minOperations(self, s: str) -> int:
        """
        3863. Minimum Operations to Sort a String
        Time: O(n)
        Space: O(1)
        """
        n = len(s)
        if all(s[i] <= s[i + 1] for i in range(n - 1)):
            return 0

        # every proper substring has length 1, so nothing can change
        if n == 2:
            return -1

        lo, hi = min(s), max(s)

        # the minimal window to sort runs from the first to the last mismatch
        # with sorted(s); one op works iff that window is not the whole string
        if s[0] == lo or s[-1] == hi:
            return 1

        # unique max stuck at index 0 and unique min stuck at index n-1: each
        # has to be relocated before it can reach its final end, and no single
        # proper window touches both ends
        if s[0] == hi and s[-1] == lo and s.count(hi) == 1 and s.count(lo) == 1:
            return 3

        # sort [0, n-2] then [1, n-1] if the min appears by index n-2,
        # otherwise sort [1, n-1] then [0, n-2]
        return 2
