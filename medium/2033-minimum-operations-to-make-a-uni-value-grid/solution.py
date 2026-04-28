from typing import List


class Solution:
    def minOperations(self, grid: List[List[int]], x: int) -> int:
        """
        2033. Minimum Operations to Make a Uni-Value Grid
        Time: O(mn * log(mn))
        Space: O(mn)
        """
        # Flatten grid
        arr = [val for row in grid for val in row]

        # Check if all elements have the same remainder mod x
        remainder = arr[0] % x
        for val in arr:
            if val % x != remainder:
                return -1

        # Sort and find median
        arr.sort()
        median = arr[len(arr) // 2]

        # Count total operations
        operations = sum(abs(val - median) // x for val in arr)

        return operations
