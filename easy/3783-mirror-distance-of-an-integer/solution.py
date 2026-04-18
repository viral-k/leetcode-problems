class Solution:
    def mirrorDistance(self, n: int) -> int:
        """
        3783. Mirror Distance of an Integer
        Time: O(log n)
        Space: O(1)
        """
        reverse_n = int(str(n)[::-1])
        return abs(n - reverse_n)
