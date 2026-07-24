from typing import List


class Solution:
    def uniqueXorTriplets(self, nums: List[int]) -> int:
        """
        3514. Number of Unique XOR Triplets II
        Time: O(D^2 + V * D)  (D = distinct values, V = 2048)
        Space: O(V)
        """
        distinct = list(set(nums))

        # All pairwise XORs; a ^ a = 0 covers reusing one index twice.
        pairs = {a ^ b for a in distinct for b in distinct}

        # XOR every pair value against every element.
        result = {p ^ c for p in pairs for c in distinct}

        return len(result)
