class Solution:
    def minMoves(self, nums: list[int]) -> int:
        """
        453. Minimum Moves to Equal Array Elements
        Time: O(n)
        Space: O(1)
        """
        # Raising n - 1 elements by 1 is the same, relative to each other, as
        # lowering the remaining one by 1. So bring every element down to the min.
        return sum(nums) - len(nums) * min(nums)
