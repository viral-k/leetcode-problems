class Solution:
    def countCommas(self, n: int) -> int:
        """
        3871. Count Commas in Range II
        Time: O(log n)
        Space: O(1)
        """
        total = 0
        threshold = 1000
        # every number >= threshold has earned one more comma
        while threshold <= n:
            total += n - threshold + 1
            threshold *= 1000
        return total
