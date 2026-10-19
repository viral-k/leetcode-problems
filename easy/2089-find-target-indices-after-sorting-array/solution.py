class Solution:
    def targetIndices(self, nums: list[int], target: int) -> list[int]:
        """
        2089. Find Target Indices After Sorting Array
        Time: O(n)
        Space: O(1)
        """
        less = 0
        count = 0
        for v in nums:
            if v < target:
                less += 1
            elif v == target:
                count += 1

        # sorting puts the copies of target in one block starting right after
        # everything smaller than it; larger values cannot shift that block
        return list(range(less, less + count))
