/**
 * 2897. Apply Operations on Array to Maximize Sum of Squares
 * Time: O((n + k) * 30)
 * Space: O(1)
 */
class Solution {
    public int maxSum(int[] nums, int k) {
        final long MOD = 1_000_000_007L;
        final int BITS = 30;  // nums[i] <= 10^9 < 2^30

        // the operation relocates bits but never creates or destroys one, so
        // the per-bit count across the array is invariant
        int[] cnt = new int[BITS];
        for (int v : nums) {
            for (int b = 0; b < BITS; b++) {
                if ((v >> b & 1) == 1) {
                    cnt[b]++;
                }
            }
        }

        // x^2 is convex, so pack bits as densely as possible: each pick takes
        // one copy of every bit still in stock
        long total = 0;
        for (int t = 0; t < k; t++) {
            long value = 0;
            for (int b = 0; b < BITS; b++) {
                if (cnt[b] > 0) {
                    cnt[b]--;
                    value |= 1L << b;
                }
            }
            // value reaches 2^30 - 1, so value * value needs long
            total = (total + value * value) % MOD;
        }

        return (int) total;
    }
}
