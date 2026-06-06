from typing import List


class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        """
        2574. Left and Right Sum Differences
        Time: O(n)
        Space: O(1)
        """
        total = sum(nums)
        left_sum = 0
        answer = []

        for num in nums:
            right_sum = total - left_sum - num
            answer.append(abs(left_sum - right_sum))
            left_sum += num

        return answer
