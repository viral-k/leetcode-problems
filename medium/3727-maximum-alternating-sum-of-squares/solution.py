from typing import List


class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        """
        3727. Maximum Alternating Sum of Squares
        Time: O(n + V) where V = 4 * 10^4
        Space: O(V)
        """
        LIMIT = 40000  # |nums[i]| <= 4 * 10^4
        n = len(nums)
        add = (n + 1) // 2  # positions 0, 2, 4, ... contribute positively

        # only the magnitude matters, since every term is squared
        cnt = [0] * (LIMIT + 1)
        for v in nums:
            cnt[v if v >= 0 else -v] += 1

        # sweep high to low so the added side gets the largest squares
        total = 0
        for a in range(LIMIT, -1, -1):
            c = cnt[a]
            if not c:
                continue
            square = a * a
            take = c if c < add else add
            total += take * square
            add -= take
            total -= (c - take) * square

        return total
