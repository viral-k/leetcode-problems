import java.util.*;

/**
 * 3505. Minimum Operations to Make Elements Within K Subarrays Equal
 * Time: O(n log n + n * k)
 * Space: O(n)
 */
class Solution {
    private int[] order;
    private PriorityQueue<Integer> lo, hi;
    private int left;

    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;

        // Unique ranks: order[r] is the index with rank r, so the heaps hold
        // plain ints and equal values stay distinguishable.
        long[] keyed = new long[n];
        for (int i = 0; i < n; i++) {
            keyed[i] = ((long) nums[i] << 17) | i;
        }
        Arrays.sort(keyed);
        order = new int[n];
        int[] rank = new int[n];
        for (int r = 0; r < n; r++) {
            order[r] = (int) (keyed[r] & ((1 << 17) - 1));
            rank[order[r]] = r;
        }

        // Sliding median. lo is a max-heap of the lower half, hi a min-heap of
        // the upper half. Counts and sums cover live elements only; an entry
        // left of the window is dropped when it reaches a top.
        lo = new PriorityQueue<>(Comparator.reverseOrder());
        hi = new PriorityQueue<>();
        int loSize = 0, hiSize = 0;
        long loSum = 0, hiSum = 0;
        boolean[] inHi = new boolean[n];
        left = 0;

        long[] cost = new long[n - x + 1];
        for (int i = 0; i < n; i++) {
            // Add nums[i] to the half it belongs in.
            clean();
            if (!lo.isEmpty() && rank[i] < lo.peek()) {
                lo.add(rank[i]);
                inHi[i] = false;
                loSize++;
                loSum += nums[i];
            } else {
                hi.add(rank[i]);
                inHi[i] = true;
                hiSize++;
                hiSum += nums[i];
            }

            // Drop the element leaving the window.
            if (i >= x) {
                int out = i - x;
                left = out + 1;
                if (inHi[out]) {
                    hiSize--;
                    hiSum -= nums[out];
                } else {
                    loSize--;
                    loSum -= nums[out];
                }
            }

            // Rebalance so lo holds ceil(size / 2) live elements.
            clean();
            while (loSize > hiSize + 1) {
                int r = lo.poll(), j = order[r];
                hi.add(r);
                inHi[j] = true;
                loSize--;
                loSum -= nums[j];
                hiSize++;
                hiSum += nums[j];
                clean();
            }
            while (loSize < hiSize) {
                int r = hi.poll(), j = order[r];
                lo.add(r);
                inHi[j] = false;
                hiSize--;
                hiSum -= nums[j];
                loSize++;
                loSum += nums[j];
                clean();
            }

            if (i >= x - 1) {
                long m = nums[order[lo.peek()]];
                cost[i - x + 1] = m * loSize - loSum + hiSum - m * hiSize;
            }
        }

        // dp[i] = cheapest way to fit the current number of windows in the
        // first i elements.
        long inf = Long.MAX_VALUE / 2;
        long[] dp = new long[n + 1];
        for (int j = 1; j <= k; j++) {
            long[] next = new long[n + 1];
            Arrays.fill(next, inf);
            for (int i = j * x; i <= n; i++) {
                next[i] = Math.min(next[i - 1], dp[i - x] + cost[i - x]);
            }
            dp = next;
        }
        return dp[n];
    }

    private void clean() {
        while (!lo.isEmpty() && order[lo.peek()] < left) {
            lo.poll();
        }
        while (!hi.isEmpty() && order[hi.peek()] < left) {
            hi.poll();
        }
    }
}
