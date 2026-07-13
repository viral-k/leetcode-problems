from typing import List


class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        """
        1291. Sequential Digits
        Time: O(1)  (36 fixed candidates)
        Space: O(1)
        """
        digits = "123456789"
        result = []
        for length in range(2, 10):
            for i in range(0, 10 - length):
                num = int(digits[i:i + length])
                if low <= num <= high:
                    result.append(num)
        result.sort()
        return result
