/**
 * 1510. Stone Game IV
 * Time: O(n * sqrt(n))
 * Space: O(n)
 */
class Solution {
    public boolean winnerSquareGame(int n) {
        // win[i] = true if the player to move with i stones wins
        boolean[] win = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int k = 1; k * k <= i; k++) {
                if (!win[i - k * k]) {
                    win[i] = true; // leave the opponent in a losing position
                    break;
                }
            }
        }
        return win[n];
    }
}
