/**
 * 52. N-Queens II
 * Time: O(n!)
 * Space: O(n)
 */
class Solution {
    private int full;

    public int totalNQueens(int n) {
        full = (1 << n) - 1;
        return backtrack(0, 0, 0);
    }

    private int backtrack(int cols, int diag, int anti) {
        if (cols == full) {
            return 1; // every row placed
        }
        int count = 0;
        int avail = ~(cols | diag | anti) & full;
        while (avail != 0) {
            int p = avail & -avail; // lowest available column
            avail -= p;
            // diagonals shift by one column as we descend a row
            count += backtrack(cols | p, ((diag | p) << 1) & full, (anti | p) >> 1);
        }
        return count;
    }
}
