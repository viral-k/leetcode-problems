class Solution:
    def numberOfSets(self, n: int, k: int) -> int:
        """
        1621. Number of Sets of K Non-Overlapping Line Segments
        Time: O(k log MOD)
        Space: O(1)
        """
        MOD = 10**9 + 7

        # Shifting segment i's endpoints up by i-1 turns the "shared endpoint
        # allowed" ordering into a strictly increasing one, so the count is
        # C(n + k - 1, 2k): choose 2k distinct positions out of n + k - 1.
        total = n + k - 1
        choose = 2 * k
        if choose > total:
            return 0

        result = 1
        for i in range(1, choose + 1):
            result = result * (total - choose + i) % MOD
            result = result * pow(i, MOD - 2, MOD) % MOD
        return result
