from typing import List


class Solution:
    def largestSquareArea(self, bottomLeft: List[List[int]], topRight: List[List[int]]) -> int:
        """
        3047. Find the Largest Area of Square Inside Two Rectangles
        Time: O(n²)
        Space: O(1)
        """
        n = len(bottomLeft)
        max_side = 0

        for i in range(n):
            ax1, ay1 = bottomLeft[i]
            ax2, ay2 = topRight[i]

            for j in range(i + 1, n):
                bx1, by1 = bottomLeft[j]
                bx2, by2 = topRight[j]

                left = max(ax1, bx1)
                right = min(ax2, bx2)
                bottom = max(ay1, by1)
                top = min(ay2, by2)

                if right > left and top > bottom:
                    side = min(right - left, top - bottom)
                    max_side = max(max_side, side)

        return max_side * max_side
