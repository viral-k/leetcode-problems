class Solution:
    def bitwiseComplement(self, n: int) -> int:
        """
        1009. Complement of Base 10 Integer
        Time: O(log n)
        Space: O(1)
        """
        if n == 0:
            return 1

        mask = 1
        while mask <= n:
            mask <<= 1

        return (mask - 1) ^ n
