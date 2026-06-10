import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * 3691. Maximum Total Subarray Value II
 * Time: O(n log n + k log k)
 * Space: O(n log n + k)
 */
class Solution {
    private int[] logTable;
    private int[][] sparseMax;
    private int[][] sparseMin;
    private int n;

    public long maxTotalValue(int[] nums, int k) {
        n = nums.length;

        logTable = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            logTable[i] = logTable[i / 2] + 1;
        }

        int levels = logTable[n] + 1;
        sparseMax = new int[levels][];
        sparseMin = new int[levels][];
        sparseMax[0] = nums.clone();
        sparseMin[0] = nums.clone();

        for (int j = 1; j < levels; j++) {
            int half = 1 << (j - 1);
            int length = n - (1 << j) + 1;
            sparseMax[j] = new int[length];
            sparseMin[j] = new int[length];
            for (int i = 0; i < length; i++) {
                sparseMax[j][i] = Math.max(sparseMax[j - 1][i], sparseMax[j - 1][i + half]);
                sparseMin[j][i] = Math.min(sparseMin[j - 1][i], sparseMin[j - 1][i + half]);
            }
        }

        // Max-heap ordered by interval value: {value, l, r}.
        PriorityQueue<long[]> heap = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));
        Set<Long> visited = new HashSet<>();

        heap.offer(new long[] {value(0, n - 1), 0, n - 1});
        visited.add(encode(0, n - 1));

        long total = 0;
        for (int step = 0; step < k; step++) {
            long[] current = heap.poll();
            int l = (int) current[1];
            int r = (int) current[2];
            total += current[0];

            if (l + 1 <= r && visited.add(encode(l + 1, r))) {
                heap.offer(new long[] {value(l + 1, r), l + 1, r});
            }
            if (l <= r - 1 && visited.add(encode(l, r - 1))) {
                heap.offer(new long[] {value(l, r - 1), l, r - 1});
            }
        }

        return total;
    }

    private long value(int l, int r) {
        int j = logTable[r - l + 1];
        int offset = r - (1 << j) + 1;
        int hi = Math.max(sparseMax[j][l], sparseMax[j][offset]);
        int lo = Math.min(sparseMin[j][l], sparseMin[j][offset]);
        return (long) (hi - lo);
    }

    private long encode(int l, int r) {
        return (long) l * n + r;
    }
}
