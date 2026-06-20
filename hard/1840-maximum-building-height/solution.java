import java.util.Arrays;

/**
 * 1840. Maximum Building Height
 * Time: O(r log r)
 * Space: O(r)
 */
class Solution {
    public int maxBuilding(int n, int[][] restrictions) {
        // Append [1, 0] as the anchor, then sort by building id.
        int r = restrictions.length;
        int[][] pts = new int[r + 1][2];
        for (int i = 0; i < r; i++) {
            pts[i][0] = restrictions[i][0];
            pts[i][1] = restrictions[i][1];
        }
        pts[r][0] = 1;
        pts[r][1] = 0;
        Arrays.sort(pts, (a, b) -> a[0] - b[0]);
        int total = pts.length;

        // Forward pass.
        for (int i = 1; i < total; i++) {
            long gap = pts[i][0] - pts[i - 1][0];
            pts[i][1] = (int) Math.min(pts[i][1], pts[i - 1][1] + gap);
        }

        // Backward pass.
        for (int i = total - 2; i >= 0; i--) {
            long gap = pts[i + 1][0] - pts[i][0];
            pts[i][1] = (int) Math.min(pts[i][1], pts[i + 1][1] + gap);
        }

        long ans = 0;

        // Peak between consecutive checkpoints.
        for (int i = 0; i < total - 1; i++) {
            long h1 = pts[i][1], h2 = pts[i + 1][1];
            long gap = pts[i + 1][0] - pts[i][0];
            ans = Math.max(ans, (h1 + h2 + gap) / 2);
        }

        // Free climb from the last checkpoint to building n.
        long lastH = pts[total - 1][1];
        long lastId = pts[total - 1][0];
        ans = Math.max(ans, lastH + (n - lastId));

        return (int) ans;
    }
}
