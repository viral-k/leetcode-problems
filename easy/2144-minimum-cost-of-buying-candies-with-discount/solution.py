from typing import List


class Solution:
    def minimumCost(self, cost: List[int]) -> int:
        """
        2144. Minimum Cost of Buying Candies With Discount
        Time: O(n log n)
        Space: O(1)
        """
        cost.sort(reverse=True)

        total = 0
        for index, candy_cost in enumerate(cost):
            if index % 3 != 2:
                total += candy_cost

        return total
