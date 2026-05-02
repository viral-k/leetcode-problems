class Solution:
    def rotatedDigits(self, n: int) -> int:
        """
        788. Rotated Digits
        Time: O(n log n)
        Space: O(1)
        """
        invalid = {3, 4, 7}
        changes = {2, 5, 6, 9}

        def is_good(num: int) -> bool:
            has_change = False

            while num > 0:
                digit = num % 10
                if digit in invalid:
                    return False
                if digit in changes:
                    has_change = True
                num //= 10

            return has_change

        return sum(1 for num in range(1, n + 1) if is_good(num))
