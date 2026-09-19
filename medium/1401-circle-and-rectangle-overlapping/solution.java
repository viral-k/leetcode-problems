/**
 * 1401. Circle and Rectangle Overlapping
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter,
                                int x1, int y1, int x2, int y2) {
        // nearest point of the rectangle to the center is the clamped center
        int cx = Math.min(Math.max(xCenter, x1), x2);
        int cy = Math.min(Math.max(yCenter, y1), y2);
        int dx = xCenter - cx;
        int dy = yCenter - cy;
        return dx * dx + dy * dy <= radius * radius;
    }
}
