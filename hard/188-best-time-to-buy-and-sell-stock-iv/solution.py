from typing import List


class Solution:
    def maxProfit(self, k: int, prices: List[int]) -> int:
        """
        188. Best Time to Buy and Sell Stock IV
        Time: O(n * k), or O(n) when k allows unlimited transactions
        Space: O(k)
        """
        n = len(prices)
        if n < 2 or k == 0:
            return 0

        # a transaction needs 2 days, so k >= n // 2 means the cap never
        # binds: just take every rise
        if k >= n // 2:
            return sum(
                max(0, prices[i] - prices[i - 1]) for i in range(1, n)
            )

        NEG = float("-inf")
        buy = [NEG] * (k + 1)   # cash while holding the j-th share
        sell = [0] * (k + 1)    # cash after closing the j-th transaction

        for p in prices:
            for j in range(1, k + 1):
                if sell[j - 1] - p > buy[j]:
                    buy[j] = sell[j - 1] - p
                if buy[j] + p > sell[j]:
                    sell[j] = buy[j] + p

        return sell[k]
