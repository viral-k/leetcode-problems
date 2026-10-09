class Solution:
    def minInsertions(self, s: str) -> int:
        """
        1541. Minimum Insertions to Balance a Parentheses String
        Time: O(n)
        Space: O(1)
        """
        n = len(s)
        open_count = 0  # '(' still awaiting their '))'
        adds = 0
        i = 0

        while i < n:
            if s[i] == "(":
                open_count += 1
                i += 1
                continue

            # consume one closer, which is two ')' wide
            if i + 1 < n and s[i + 1] == ")":
                i += 2
            else:
                adds += 1  # the second ')' is missing
                i += 1

            if open_count > 0:
                open_count -= 1
            else:
                adds += 1  # no '(' pending, so one must go before this closer

        # every leftover '(' still needs a full '))'
        return adds + 2 * open_count
