/**
 * 3660. Jump Game IX
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] suffixMin = new int[n];
        suffixMin[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(nums[i], suffixMin[i + 1]);
        }

        int[] ans = new int[n];
        int start = 0;
        int componentMax = nums[0];

        for (int i = 0; i < n; i++) {
            componentMax = Math.max(componentMax, nums[i]);

            if (i == n - 1 || componentMax <= suffixMin[i + 1]) {
                for (int j = start; j <= i; j++) {
                    ans[j] = componentMax;
                }

                if (i + 1 < n) {
                    start = i + 1;
                    componentMax = nums[start];
                }
            }
        }

        return ans;
    }
}
