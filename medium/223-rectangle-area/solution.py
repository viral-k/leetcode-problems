class Solution:
    def computeArea(
        self, ax1: int, ay1: int, ax2: int, ay2: int, 
        bx1: int, by1: int, bx2: int, by2: int
    ) -> int:
        """
        223. Rectangle Area
        Time: O(1)
        Space: O(1)
        """
        total_area = ((ax2 - ax1) * (ay2 - ay1)) + ((bx2 - bx1) * (by2 - by1))
        
        intersected_left = max(ax1, bx1)
        intersected_right = min(ax2, bx2)
        intersected_horizontal = intersected_right - intersected_left if intersected_right > intersected_left else 0
        
        intersected_bottom = max(ay1, by1)
        intersected_top = min(ay2, by2)
        intersected_vertical = intersected_top - intersected_bottom if intersected_top > intersected_bottom else 0
        
        intersected_area = intersected_horizontal * intersected_vertical
        
        return total_area - intersected_area
