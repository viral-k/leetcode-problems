from typing import List


class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        """
        2553. Separate the Digits in an Array
        Time: O(d)
        Space: O(d)
        """
        answer = []

        for num in nums:
            for digit in str(num):
                answer.append(int(digit))

        return answer
