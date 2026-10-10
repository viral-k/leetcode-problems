/**
 * 2333. Minimum Sum of Squared Difference
 * Time: O(n + V) where V = max difference
 * Space: O(V)
 */
class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long budget = (long) k1 + k2;  // an op on either array moves one difference by 1

        int top = 0;
        long total = 0;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            total += diffs[i];
            top = Math.max(top, diffs[i]);
        }

        if (total <= budget) {
            return 0;
        }

        long[] cnt = new long[top + 1];
        for (int d : diffs) {
            cnt[d]++;
        }

        // cutting the largest value saves 2v-1, the most available, so sweep
        // down moving whole buckets while the budget covers them
        for (int v = top; v >= 1; v--) {
            if (cnt[v] == 0) {
                continue;
            }
            if (budget >= cnt[v]) {
                budget -= cnt[v];
                cnt[v - 1] += cnt[v];
                cnt[v] = 0;
            } else {
                cnt[v] -= budget;
                cnt[v - 1] += budget;
                break;
            }
        }

        long result = 0;
        for (int v = 1; v <= top; v++) {
            result += (long) v * v * cnt[v];
        }
        return result;
    }
}
