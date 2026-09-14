from typing import List


class Solution:
    def isRectangleOverlap(self, rec1: List[int], rec2: List[int]) -> bool:
        """
        836. Rectangle Overlap
        Time: O(1)
        Space: O(1)
        """
        # overlap on both axes; strict so touching edges do not count
        x_overlap = rec1[0] < rec2[2] and rec2[0] < rec1[2]
        y_overlap = rec1[1] < rec2[3] and rec2[1] < rec1[3]
        return x_overlap and y_overlap
