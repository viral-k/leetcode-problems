/**
 * 2078. Two Furthest Houses With Different Colors
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxDistance(int[] colors) {
        int n = colors.length;
        int dist = 0;

        // Check from first house - find furthest different color
        for (int j = n - 1; j >= 0; j--) {
            if (colors[j] != colors[0]) {
                dist = Math.max(dist, j);
                break;
            }
        }

        // Check from last house - find furthest different color
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[n - 1]) {
                dist = Math.max(dist, n - 1 - i);
                break;
            }
        }

        return dist;
    }
}
