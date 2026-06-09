/**
 * 3689. Maximum Total Subarray Value I
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int globalMax = nums[0];
        int globalMin = nums[0];

        for (int num : nums) {
            globalMax = Math.max(globalMax, num);
            globalMin = Math.min(globalMin, num);
        }

        return (long) k * (globalMax - globalMin);
    }
}
