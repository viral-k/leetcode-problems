class Solution:
    def smallestNumber(self, n: int, t: int) -> int:
        """
        3345. Smallest Divisible Digit Product I
        Time: O(A * d)
        Space: O(1)
        """
        x = n
        while True:
            product = 1
            for ch in str(x):
                product *= int(ch)
            if product % t == 0:
                return x
            x += 1
