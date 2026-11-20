import java.util.Arrays;

/**
 * 3041. Maximize Consecutive Elements in an Array After Modification
 * Time: O(n log n)
 * Space: O(max)
 */
class Solution {
    public int maxSelectedElements(int[] nums) {
        Arrays.sort(nums);
        // dp[v] = longest run of consecutive values ending exactly at v.
        int[] dp = new int[nums[nums.length - 1] + 2];
        int best = 0;
        for (int x : nums) {
            // Use x as x + 1 first: it needs dp[x] from before this element.
            dp[x + 1] = dp[x] + 1;
            // Use x as itself, extending a run that ends at x - 1.
            dp[x] = dp[x - 1] + 1;
            best = Math.max(best, Math.max(dp[x], dp[x + 1]));
        }
        return best;
    }
}
