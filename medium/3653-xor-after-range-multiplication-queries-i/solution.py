from typing import List


class Solution:
    def xorAfterMultiplication(self, nums: List[int], queries: List[List[int]]) -> int:
        """
        3653. XOR After Range Multiplication Queries I
        Time: O(q × n)
        Space: O(1)
        """
        MOD = 10**9 + 7

        for l, r, k, v in queries:
            idx = l
            while idx <= r:
                nums[idx] = (nums[idx] * v) % MOD
                idx += k

        result = 0
        for num in nums:
            result ^= num

        return result
