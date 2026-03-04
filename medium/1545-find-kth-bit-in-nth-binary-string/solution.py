class Solution:
    def findKthBit(self, n: int, k: int) -> str:
        """
        1545. Find Kth Bit in Nth Binary String
        Time: O(n)
        Space: O(n)
        """
        if n == 1:
            return "0"

        mid = 1 << (n - 1)  # 2^(n-1)

        if k == mid:
            return "1"
        elif k < mid:
            return self.findKthBit(n - 1, k)
        else:
            mirror = (1 << n) - k
            bit = self.findKthBit(n - 1, mirror)
            return "1" if bit == "0" else "0"
