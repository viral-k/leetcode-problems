from typing import List


class Solution:
    def minMoves(self, nums: List[int], limit: int) -> int:
        """
        1674. Minimum Moves to Make Array Complementary
        Time: O(n + limit)
        Space: O(limit)
        """
        diff = [0] * (2 * limit + 2)
        n = len(nums)

        for i in range(n // 2):
            a = nums[i]
            b = nums[n - 1 - i]
            low = 1 + min(a, b)
            high = limit + max(a, b)
            total = a + b

            diff[2] += 2
            diff[low] -= 1
            diff[high + 1] += 1
            diff[total] -= 1
            diff[total + 1] += 1

        answer = n
        moves = 0

        for target in range(2, 2 * limit + 1):
            moves += diff[target]
            answer = min(answer, moves)

        return answer
