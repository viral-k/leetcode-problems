import java.util.ArrayList;
import java.util.List;

/**
 * 835. Image Overlap
 * Time: O(k1 * k2)
 * Space: O(n^2)
 */
class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        List<int[]> ones1 = new ArrayList<>();
        List<int[]> ones2 = new ArrayList<>();
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (img1[r][c] == 1) {
                    ones1.add(new int[]{r, c});
                }
                if (img2[r][c] == 1) {
                    ones2.add(new int[]{r, c});
                }
            }
        }

        // vector components lie in [-(n-1), n-1]; shift by n-1 to index a flat array
        int span = 2 * n - 1;
        int[] votes = new int[span * span];
        int best = 0;

        // each (1, 1) pair votes for the one translation that aligns them
        for (int[] p1 : ones1) {
            for (int[] p2 : ones2) {
                int dr = p2[0] - p1[0] + n - 1;
                int dc = p2[1] - p1[1] + n - 1;
                int key = dr * span + dc;
                votes[key]++;
                if (votes[key] > best) {
                    best = votes[key];
                }
            }
        }

        return best;
    }
}
