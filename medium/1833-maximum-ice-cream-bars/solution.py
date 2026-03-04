from typing import List


class Solution:
    def maxIceCream(self, costs: List[int], coins: int) -> int:
        """
        1833. Maximum Ice Cream Bars
        Time: O(n + m)
        Space: O(m)
        """
        max_cost = max(costs)
        frequency = [0] * (max_cost + 1)
        for cost in costs:
            frequency[cost] += 1

        answer = 0

        for cost in range(1, max_cost + 1):
            total_cost = cost * frequency[cost]
            if coins >= total_cost:
                coins -= total_cost
                answer += frequency[cost]
            else:
                answer += coins // cost
                break

        return answer
