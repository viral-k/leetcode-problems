/**
 * 2574. Left and Right Sum Differences
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int[] leftRightDifference(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }

        int leftSum = 0;
        int[] answer = new int[nums.length];

        for (int index = 0; index < nums.length; index++) {
            int rightSum = total - leftSum - nums[index];
            answer[index] = Math.abs(leftSum - rightSum);
            leftSum += nums[index];
        }

        return answer;
    }
}
