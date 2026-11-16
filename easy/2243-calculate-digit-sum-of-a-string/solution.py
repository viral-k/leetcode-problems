class Solution:
    def digitSum(self, s: str, k: int) -> str:
        """
        2243. Calculate Digit Sum of a String
        Time: O(n), the length shrinks geometrically (every other round when k = 2)
        Space: O(n)
        """
        while len(s) > k:
            s = "".join(
                str(sum(int(c) for c in s[i:i + k])) for i in range(0, len(s), k)
            )
        return s
