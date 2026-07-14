from typing import List
from math import gcd


class Solution:
    def subsequencePairCount(self, nums: List[int]) -> int:
        """
        3336. Find the Number of Subsequences With Equal GCD
        Time: O(n * V^2)
        Space: O(V^2)
        """
        MOD = 10**9 + 7
        V = max(nums)

        # dp[g1][g2]: ways so far; 0 means "empty" (gcd(0, x) = x).
        dp = [[0] * (V + 1) for _ in range(V + 1)]
        dp[0][0] = 1

        for num in nums:
            nxt = [row[:] for row in dp]  # start from "skip" choice
            for g1 in range(V + 1):
                row = dp[g1]
                for g2 in range(V + 1):
                    c = row[g2]
                    if c == 0:
                        continue
                    ng1 = gcd(g1, num)  # gcd(0, num) == num
                    ng2 = gcd(g2, num)
                    nxt[ng1][g2] = (nxt[ng1][g2] + c) % MOD  # add to seq1
                    nxt[g1][ng2] = (nxt[g1][ng2] + c) % MOD  # add to seq2
            dp = nxt

        return sum(dp[g][g] for g in range(1, V + 1)) % MOD
