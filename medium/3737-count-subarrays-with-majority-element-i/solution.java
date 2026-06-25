/**
 * 3737. Count Subarrays With Majority Element I
 * Time: O(n^2)
 * Space: O(1)
 */
class Solution {
    public int countSubarrays(int[] nums, int target) {
        int n = nums.length, ans = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = i; j < n; j++) {
                if (nums[j] == target) count++;
                if (count * 2 > j - i + 1) ans++;
            }
        }
        return ans;
    }
}
