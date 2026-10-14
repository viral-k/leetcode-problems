class Solution:
    def maxSumOfSquares(self, num: int, sum: int) -> str:
        """
        3723. Maximize Sum of Squares of Digits
        Time: O(num)
        Space: O(num)
        """
        # an num-digit integer has digit sum in [1, 9 * num]
        if sum > 9 * num:
            return ""

        # sum of squares is convex, so the optimum sits at a box vertex:
        # every digit 0 or 9 except at most one
        nines, rest = divmod(sum, 9)

        middle = str(rest) if rest else ""
        zeros = num - nines - (1 if rest else 0)

        # descending order is the largest arrangement, and sum >= 1 means
        # the leading digit is never zero
        return "9" * nines + middle + "0" * zeros
