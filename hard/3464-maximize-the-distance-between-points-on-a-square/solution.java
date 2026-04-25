import java.util.*;

/**
 * 3464. Maximize the Distance Between Points on a Square
 * Time: O(n * k * log n * log(perimeter/k))
 * Space: O(n)
 */
class Solution {
    private long[] extended;
    private int n;
    private int k;

    public int maxDistance(int side, int[][] points, int k) {
        this.k = k;
        long perimeter = 4L * side;

        long[] positions = new long[points.length];
        for (int i = 0; i < points.length; i++) {
            positions[i] = toPerimeterPos(points[i][0], points[i][1], side);
        }
        Arrays.sort(positions);
        n = positions.length;

        // Double array for cyclic handling
        extended = new long[2 * n];
        for (int i = 0; i < n; i++) {
            extended[i] = positions[i];
            extended[i + n] = positions[i] + perimeter;
        }

        long lo = 1, hi = perimeter / k;
        long ans = 1;

        while (lo <= hi) {
            long mid = (lo + hi) / 2;
            if (canAchieve(mid)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return (int) ans;
    }

    private long toPerimeterPos(int x, int y, int side) {
        if (y == 0) {
            return x;
        } else if (x == side) {
            return (long) side + y;
        } else if (y == side) {
            return 2L * side + (side - x);
        } else {
            return 3L * side + (side - y);
        }
    }

    private boolean canAchieve(long d) {
        for (int start = 0; start < n; start++) {
            int count = 1;
            int lastIdx = start;

            for (int i = 0; i < k - 1; i++) {
                long target = extended[lastIdx] + d;
                int nextIdx = lowerBound(extended, target, lastIdx + 1, start + n);

                if (nextIdx >= start + n) {
                    break;
                }

                count++;
                lastIdx = nextIdx;
            }

            if (count == k) {
                long wrapDist = extended[start + n] - extended[lastIdx];
                if (wrapDist >= d) {
                    return true;
                }
            }
        }

        return false;
    }

    private int lowerBound(long[] arr, long target, int lo, int hi) {
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] >= target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
