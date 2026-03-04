from typing import List


class Solution:
    def maximizeSquareArea(
        self, m: int, n: int, hFences: List[int], vFences: List[int]
    ) -> int:
        """
        2975. Maximum Square Area by Removing Fences From a Field
        Time: O(h² + v²)
        Space: O(h²)
        """
        MOD = 10**9 + 7

        horizontal_fences = [1] + hFences + [m]
        vertical_fences = [1] + vFences + [n]

        horizontal_fences.sort()
        vertical_fences.sort()

        distance_set = set()

        for i in range(len(horizontal_fences)):
            for j in range(i + 1, len(horizontal_fences)):
                distance_set.add(horizontal_fences[j] - horizontal_fences[i])

        max_side = -1

        for i in range(len(vertical_fences)):
            for j in range(i + 1, len(vertical_fences)):
                distance = vertical_fences[j] - vertical_fences[i]
                if distance in distance_set:
                    max_side = max(max_side, distance)

        if max_side == -1:
            return -1

        return (max_side * max_side) % MOD
