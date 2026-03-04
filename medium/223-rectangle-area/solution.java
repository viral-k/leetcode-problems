/**
 * 223. Rectangle Area
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, 
                           int bx1, int by1, int bx2, int by2) {
        int totalArea = ((ax2 - ax1) * (ay2 - ay1)) + ((bx2 - bx1) * (by2 - by1));
        
        int intersectedLeft = Math.max(ax1, bx1);
        int intersectedRight = Math.min(ax2, bx2);
        int intersectedHorizontal = intersectedRight > intersectedLeft ? intersectedRight - intersectedLeft : 0;
        
        int intersectedBottom = Math.max(ay1, by1);
        int intersectedTop = Math.min(ay2, by2);
        int intersectedVertical = intersectedTop > intersectedBottom ? intersectedTop - intersectedBottom : 0;
        
        int intersectedArea = intersectedHorizontal * intersectedVertical;
        
        return totalArea - intersectedArea;
    }
}
