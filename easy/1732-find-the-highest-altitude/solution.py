from typing import List


class Solution:
    def largestAltitude(self, gain: List[int]) -> int:
        """
        1732. Find the Highest Altitude
        Time: O(n)
        Space: O(1)
        """
        altitude = 0
        highest = 0

        for g in gain:
            altitude += g
            highest = max(highest, altitude)

        return highest
