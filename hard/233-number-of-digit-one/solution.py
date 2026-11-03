class Solution:
    def countDigitOne(self, n: int) -> int:
        """
        233. Number of Digit One
        Time: O(log n)
        Space: O(1)
        """
        count = 0
        p = 1
        while p <= n:
            high, cur, low = n // (p * 10), (n // p) % 10, n % p
            # Each full block of 10p numbers has p ones at this position.
            count += high * p
            # The partial block: before, inside, or past the run of 1s.
            if cur == 1:
                count += low + 1
            elif cur > 1:
                count += p
            p *= 10
        return count
