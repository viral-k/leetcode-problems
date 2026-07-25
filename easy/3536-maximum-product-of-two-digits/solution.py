class Solution:
    def maxProduct(self, n: int) -> int:
        """
        3536. Maximum Product of Two Digits
        Time: O(d)
        Space: O(1)
        """
        max1 = max2 = -1  # two largest digit values
        for ch in str(n):
            d = int(ch)
            if d >= max1:
                max2 = max1
                max1 = d
            elif d > max2:
                max2 = d
        return max1 * max2
