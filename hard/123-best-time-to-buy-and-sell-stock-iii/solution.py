from typing import List


class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        """
        123. Best Time to Buy and Sell Stock III
        Time: O(n)
        Space: O(1)
        """
        NEG = float("-inf")
        buy1 = buy2 = NEG   # cash while holding the 1st / 2nd share
        sell1 = sell2 = 0   # cash after selling the 1st / 2nd share

        for p in prices:
            buy1 = max(buy1, -p)
            sell1 = max(sell1, buy1 + p)
            buy2 = max(buy2, sell1 - p)
            sell2 = max(sell2, buy2 + p)

        return sell2
