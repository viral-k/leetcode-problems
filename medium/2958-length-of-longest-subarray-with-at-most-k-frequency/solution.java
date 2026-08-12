import java.util.HashMap;
import java.util.Map;

/**
 * 2958. Length of Longest Subarray With at Most K Frequency
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        int left = 0, best = 0;

        for (int r = 0; r < nums.length; r++) {
            int x = nums[r];
            freq.merge(x, 1, Integer::sum);
            // only the just-added value can violate the limit
            while (freq.get(x) > k) {
                freq.merge(nums[left], -1, Integer::sum);
                left++;
            }
            best = Math.max(best, r - left + 1);
        }

        return best;
    }
}
