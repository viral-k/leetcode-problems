import java.util.*;

/**
 * 3661. Maximum Walls Destroyed by Robots
 * Time: O(n log n + m log m)
 * Space: O(n)
 */
class Solution {
    public int maxWallsDestroyed(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int[][] robotsWithD = new int[n][2];
        for (int i = 0; i < n; i++) {
            robotsWithD[i][0] = robots[i];
            robotsWithD[i][1] = distance[i];
        }
        Arrays.sort(robotsWithD, (a, b) -> a[0] - b[0]);

        int[] pos = new int[n];
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            pos[i] = robotsWithD[i][0];
            dist.put(robotsWithD[i][0], robotsWithD[i][1]);
        }

        Arrays.sort(walls);

        int[] leftL = new int[n];
        int[] leftR = new int[n];
        int[] rightL = new int[n];
        int[] rightR = new int[n];

        for (int i = 0; i < n; i++) {
            int p = pos[i];
            int d = dist.get(p);

            long L = p - d;
            if (i > 0) {
                L = Math.max(L, pos[i - 1] + 1);
            }

            leftL[i] = lowerBound(walls, L);
            leftR[i] = upperBound(walls, p) - 1;

            long R = p + d;
            if (i < n - 1) {
                R = Math.min(R, pos[i + 1] - 1);
            }

            rightL[i] = lowerBound(walls, p);
            rightR[i] = upperBound(walls, R) - 1;
        }

        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 0; i < n; i++) {
            left[i] = Math.max(0, leftR[i] - leftL[i] + 1);
            right[i] = Math.max(0, rightR[i] - rightL[i] + 1);
        }

        int[] overlap = new int[n];
        for (int i = 1; i < n; i++) {
            int l = Math.max(rightL[i - 1], leftL[i]);
            int r = Math.min(rightR[i - 1], leftR[i]);
            overlap[i] = Math.max(0, r - l + 1);
        }

        int subLeft = left[0];
        int subRight = right[0];

        for (int i = 1; i < n; i++) {
            int currentLeft = Math.max(
                subLeft + left[i],
                subRight + left[i] - overlap[i]
            );

            int currentRight = Math.max(
                subLeft + right[i],
                subRight + right[i]
            );

            subLeft = currentLeft;
            subRight = currentRight;
        }

        return Math.max(subLeft, subRight);
    }

    private int lowerBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] < target) l = mid + 1;
            else r = mid;
        }
        return l;
    }

    private int upperBound(int[] arr, long target) {
        int l = 0, r = arr.length;
        while (l < r) {
            int mid = (l + r) / 2;
            if (arr[mid] <= target) l = mid + 1;
            else r = mid;
        }
        return l;
    }
}
