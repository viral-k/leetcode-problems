class Solution:
    def concatenateAndMultiply(self, n: int) -> int:
        """
        3754. Concatenate Non-Zero Digits and Multiply by Sum I
        Time: O(d)
        Space: O(1)
        """
        x = 0
        total = 0
        for ch in str(n):
            d = int(ch)
            if d != 0:
                x = x * 10 + d
                total += d
        return x * total
