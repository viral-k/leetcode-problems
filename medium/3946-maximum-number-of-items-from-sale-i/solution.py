from typing import List


class Solution:
    def maximumSaleItems(self, items: List[List[int]], budget: int) -> int:
        """
        3946. Maximum Number of Items From Sale I
        Time: O(n * budget + F log F), F = max factor
        Space: O(budget + F)
        """
        max_f = max(f for f, _ in items)
        cnt = [0] * (max_f + 1)
        for f, _ in items:
            cnt[f] += 1

        # The first copy of item i is worth 1 + (other items whose factor is a multiple of factor_i).
        bonus = {}
        for f in set(f for f, _ in items):
            bonus[f] = sum(cnt[m] for m in range(f, max_f + 1, f)) - 1

        # 0/1 knapsack over first copies: dp[c] = best value with total price <= c.
        dp = [0] * (budget + 1)
        for f, p in items:
            if p > budget:
                continue
            v = 1 + bonus[f]
            for c in range(budget, p - 1, -1):
                if dp[c - p] + v > dp[c]:
                    dp[c] = dp[c - p] + v

        # Extra copies are worth 1 each, so spend the leftover on the cheapest item.
        p_min = min(p for _, p in items)
        return max(dp[c] + (budget - c) // p_min for c in range(budget + 1))
