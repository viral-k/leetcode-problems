/**
 * 453. Minimum Moves to Equal Array Elements
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int x : nums) {
            min = Math.min(min, x);
        }
        // Raising n - 1 elements by 1 is the same, relative to each other, as
        // lowering the remaining one by 1. So bring every element down to the min.
        long moves = 0;
        for (int x : nums) {
            moves += (long) x - min;
        }
        return (int) moves;
    }
}
