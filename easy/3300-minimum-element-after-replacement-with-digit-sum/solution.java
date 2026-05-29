/**
 * 3300. Minimum Element After Replacement With Digit Sum
 * Time: O(n * D)
 * Space: O(1)
 */
class Solution {
    public int minElement(int[] nums) {
        int answer = Integer.MAX_VALUE;

        for (int num : nums) {
            answer = Math.min(answer, digitSum(num));
        }

        return answer;
    }

    private int digitSum(int num) {
        int total = 0;
        while (num > 0) {
            total += num % 10;
            num /= 10;
        }
        return total;
    }
}
