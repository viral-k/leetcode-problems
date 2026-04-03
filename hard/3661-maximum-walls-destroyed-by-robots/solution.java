import java.util.*;

/**
 * 3661. Maximum Walls Destroyed by Robots
 * Time: O(n log n + m log m)
 * Space: O(n + m)
 */
class Solution {
    public int maxWallsDestroyed(int[] robots, int[] distance, int[] walls) {
        int n = robots.length;

        int[][] r = new int[n][2];
        for (int i = 0; i < n; i++) {
            r[i][0] = robots[i];
            r[i][1] = distance[i];
        }

        Arrays.sort(r, (a, b) -> a[0] - b[0]);
        Arrays.sort(walls);

        int[] pos = new int[n];
        for (int i = 0; i < n; i++) pos[i] = r[i][0];

        List<long[]> intervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int p = r[i][0], d = r[i][1];

            long leftBlock = (i > 0) ? pos[i - 1] : Long.MIN_VALUE;
            long L = Math.max(p - d, leftBlock);
            long R = p;
            intervals.add(new long[]{L, R});

            long rightBlock = (i < n - 1) ? pos[i + 1] : Long.MAX_VALUE;
            L = p;
            R = Math.min(p + d, rightBlock);
            intervals.add(new long[]{L, R});
        }

        intervals.sort((a, b) -> Long.compare(a[1], b[1]));

        Set<Integer> used = new HashSet<>();
        int res = 0;

        for (long[] in : intervals) {
            long L = in[0], R = in[1];

            int l = lowerBound(walls, L);
            int rIdx = upperBound(walls, R);

            for (int i = l; i < rIdx; i++) {
                if (!used.contains(walls[i])) {
                    used.add(walls[i]);
                    res++;
                }
            }
        }

        return res;
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
