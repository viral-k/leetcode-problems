/**
 * 3739. Count Subarrays With Majority Element II
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public long countSubarrays(int[] nums, int target) {
        int n = nums.length;
        // freq[v] = how many prefix sums seen so far equal value v (shifted by n).
        int[] freq = new int[2 * n + 1];
        int i = n;        // current prefix sum, shifted: i = n means s = 0
        freq[i] = 1;      // register s[0] = 0
        long pref = 0;    // count of earlier prefixes strictly less than current
        long res = 0;

        for (int num : nums) {
            if (num == target) {
                // prefix goes up: prefixes equal to old i become strictly less
                pref += freq[i];
                i += 1;
            } else {
                // prefix goes down: prefixes equal to new i are no longer less
                i -= 1;
                pref -= freq[i];
            }
            freq[i] += 1;
            res += pref;
        }
        return res;
    }
}
