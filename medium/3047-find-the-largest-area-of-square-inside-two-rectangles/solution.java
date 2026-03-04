/**
 * 3047. Find the Largest Area of Square Inside Two Rectangles
 * Time: O(n²)
 * Space: O(1)
 */
class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        int n = bottomLeft.length;
        long maxSide = 0;

        for (int i = 0; i < n; i++) {
            int ax1 = bottomLeft[i][0];
            int ay1 = bottomLeft[i][1];
            int ax2 = topRight[i][0];
            int ay2 = topRight[i][1];

            for (int j = i + 1; j < n; j++) {
                int bx1 = bottomLeft[j][0];
                int by1 = bottomLeft[j][1];
                int bx2 = topRight[j][0];
                int by2 = topRight[j][1];

                int left = Math.max(ax1, bx1);
                int right = Math.min(ax2, bx2);
                int bottom = Math.max(ay1, by1);
                int top = Math.min(ay2, by2);

                if (right > left && top > bottom) {
                    long side = Math.min(right - left, top - bottom);
                    maxSide = Math.max(maxSide, side);
                }
            }
        }

        return maxSide * maxSide;
    }
}
