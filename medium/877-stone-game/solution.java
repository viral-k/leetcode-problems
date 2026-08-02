/**
 * 877. Stone Game
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    public boolean stoneGame(int[] piles) {
        // Even pile count + odd total => the first player can always win
        // (commit to all even-indexed or all odd-indexed piles, take the larger group).
        return true;
    }
}
