/**
 * 3524. Find X Value of Array I
 * Time: O(n * k)
 * Space: O(k)
 */
class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        // cnt[x] = number of subarrays ending at the current index with
        // product % k == x
        long[] cnt = new long[k];

        for (int v : nums) {
            int m = v % k;
            long[] next = new long[k];
            for (int x = 0; x < k; x++) {
                if (cnt[x] != 0) {
                    next[x * m % k] += cnt[x];
                }
            }
            next[m] += 1;  // the one-element subarray [v]

            for (int x = 0; x < k; x++) {
                result[x] += next[x];
            }
            cnt = next;
        }

        return result;
    }
}
