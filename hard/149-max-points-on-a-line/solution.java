import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 * Time: O(n^2)
 * Space: O(n)
 */
class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n < 3) {
            return n;
        }

        int best = 2;
        Map<Integer, Integer> slopes = new HashMap<>();
        for (int i = 0; i < n; i++) {
            slopes.clear();
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int dx = points[j][0] - x1;
                int dy = points[j][1] - y1;

                // canonical direction: reduce by gcd, then force dx > 0
                // (or dy = 1 when vertical) so opposite directions agree
                int g = gcd(Math.abs(dx), Math.abs(dy));
                dx /= g;
                dy /= g;
                if (dx < 0) {
                    dx = -dx;
                    dy = -dy;
                } else if (dx == 0) {
                    dy = 1;
                }

                // dx, dy fit well within +/- 20000, so pack into one int key
                int key = dx * 40001 + dy;
                int count = slopes.merge(key, 1, Integer::sum);
                if (count + 1 > best) {
                    best = count + 1;
                }
            }
        }

        return best;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
