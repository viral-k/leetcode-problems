/**
 * 3736. Minimum Moves to Equal Array Elements III
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minMoves(int[] nums) {
        int max = 0, sum = 0;
        for (int x : nums) {
            max = Math.max(max, x);
            sum += x;
        }
        // Values only go up, so everything rises to the current max.
        return nums.length * max - sum;
    }
}
