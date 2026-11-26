/**
 * 3360. Stone Removal Game
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    public boolean canAliceWin(int n) {
        // The moves are forced: 10, 9, 8, ... Whoever can't match theirs loses.
        int take = 10;
        int moves = 0;
        while (n >= take) {
            n -= take;
            take--;
            moves++;
        }
        return moves % 2 == 1;
    }
}
