from typing import List
from collections import defaultdict


class Solution:
    def maxNumberOfFamilies(self, n: int, reservedSeats: List[List[int]]) -> int:
        """
        1386. Cinema Seat Allocation
        Time: O(m)
        Space: O(m)
        """
        # Bit mask of taken seats per row (bit s-1 set means seat s reserved).
        taken = defaultdict(int)
        for row, seat in reservedSeats:
            taken[row] |= 1 << (seat - 1)

        LEFT = 0b0000011110   # seats 2,3,4,5
        MIDDLE = 0b0001111000  # seats 4,5,6,7
        RIGHT = 0b0111100000   # seats 6,7,8,9

        total = 2 * n  # every untouched row seats exactly 2 groups
        for mask in taken.values():
            left_free = (mask & LEFT) == 0
            mid_free = (mask & MIDDLE) == 0
            right_free = (mask & RIGHT) == 0

            if left_free and right_free:
                value = 2
            elif left_free or mid_free or right_free:
                value = 1
            else:
                value = 0

            total += value - 2  # correct the baseline for this row
        return total
