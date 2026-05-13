/**
 * 1674. Minimum Moves to Make Array Complementary
 * Time: O(n + limit)
 * Space: O(limit)
 */
class Solution {
    public int minMoves(int[] nums, int limit) {
        int[] diff = new int[2 * limit + 2];
        int n = nums.length;

        for (int i = 0; i < n / 2; i++) {
            int a = nums[i];
            int b = nums[n - 1 - i];
            int low = 1 + Math.min(a, b);
            int high = limit + Math.max(a, b);
            int total = a + b;

            diff[2] += 2;
            diff[low] -= 1;
            diff[high + 1] += 1;
            diff[total] -= 1;
            diff[total + 1] += 1;
        }

        int answer = n;
        int moves = 0;

        for (int target = 2; target <= 2 * limit; target++) {
            moves += diff[target];
            answer = Math.min(answer, moves);
        }

        return answer;
    }
}
