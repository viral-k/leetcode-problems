class Solution:
    def checkDivisibility(self, n: int) -> bool:
        """
        3622. Check Divisibility by Digit Sum and Product
        Time: O(d)
        Space: O(1)
        """
        digit_sum = 0
        digit_product = 1
        x = n
        while x > 0:
            d = x % 10
            digit_sum += d
            digit_product *= d
            x //= 10

        # digit_sum >= 1 for any positive n, so the divisor is never zero
        return n % (digit_sum + digit_product) == 0
