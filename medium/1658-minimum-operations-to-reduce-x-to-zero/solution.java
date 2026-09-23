/**
 * 1658. Minimum Operations to Reduce X to Zero
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minOperations(int[] nums, int x) {
        int n = nums.length;
        long total = 0;
        for (int v : nums) {
            total += v;
        }
        long target = total - x;
        if (target < 0) {
            return -1;
        }

        // fewest removals == longest middle subarray summing to target
        int best = target == 0 ? 0 : -1;
        long window = 0;
        int left = 0;

        for (int right = 0; right < n; right++) {
            window += nums[right];
            while (window > target) {
                window -= nums[left];
                left++;
            }
            if (window == target) {
                best = Math.max(best, right - left + 1);
            }
        }

        return best < 0 ? -1 : n - best;
    }
}
