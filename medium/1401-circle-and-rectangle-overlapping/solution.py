class Solution:
    def checkOverlap(
        self,
        radius: int,
        xCenter: int,
        yCenter: int,
        x1: int,
        y1: int,
        x2: int,
        y2: int,
    ) -> bool:
        """
        1401. Circle and Rectangle Overlapping
        Time: O(1)
        Space: O(1)
        """
        # nearest point of the rectangle to the center is the clamped center
        cx = min(max(xCenter, x1), x2)
        cy = min(max(yCenter, y1), y2)
        dx = xCenter - cx
        dy = yCenter - cy
        return dx * dx + dy * dy <= radius * radius
