/**
 * 486. Predict the Winner
 * Time: O(n^2)
 * Space: O(n)
 */
class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        // dp[j] holds dp[i][j] for the current i, rolling i from high to low.
        int[] dp = nums.clone(); // base case: dp[i][i] = nums[i]
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] >= 0;
    }
}
