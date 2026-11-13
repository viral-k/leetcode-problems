/**
 * 3420. Count Non-Decreasing Subarrays After K Operations
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        // Window nums[l..r] split into blocks, left to right. Block i covers cnt[i]
        // elements whose prefix max (from l) is val[i]. Values strictly increase
        // from head to tail. Blocks are only pushed at the head, at most n times,
        // so head counts down from n and never goes below 0.
        long[] val = new long[n];
        int[] cnt = new int[n];
        int head = n, tail = n; // live blocks are [head, tail)
        long cost = 0; // sum of (prefix max - nums[i]) over the window
        int r = n - 1;
        long ans = 0;

        for (int l = n - 1; l >= 0; l--) {
            // nums[l] becomes the prefix max of every block it is >= to.
            int count = 1;
            while (head < tail && val[head] <= nums[l]) {
                cost += (nums[l] - val[head]) * cnt[head];
                count += cnt[head];
                head++;
            }
            head--;
            val[head] = nums[l];
            cnt[head] = count;

            // Too expensive: drop elements from the right. nums[r] is in the
            // last block, and leaving takes its (value - nums[r]) with it.
            while (cost > k) {
                cost -= val[tail - 1] - nums[r];
                if (--cnt[tail - 1] == 0) {
                    tail--;
                }
                r--;
            }

            ans += r - l + 1;
        }
        return ans;
    }
}
