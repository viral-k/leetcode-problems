import java.util.ArrayList;
import java.util.List;

/**
 * 51. N-Queens
 * Time: O(n!)
 * Space: O(n) excluding the output
 */
class Solution {
    private int n;
    private int[] placement;      // placement[row] = chosen column
    private boolean[] cols;
    private boolean[] diags;      // indexed by row - col + n, constant along "\"
    private boolean[] antis;      // indexed by row + col, constant along "/"
    private List<List<String>> result;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        placement = new int[n];
        cols = new boolean[n];
        diags = new boolean[2 * n];
        antis = new boolean[2 * n];
        result = new ArrayList<>();
        backtrack(0);
        return result;
    }

    private void backtrack(int row) {
        if (row == n) {
            List<String> board = new ArrayList<>(n);
            for (int c : placement) {
                char[] line = new char[n];
                java.util.Arrays.fill(line, '.');
                line[c] = 'Q';
                board.add(new String(line));
            }
            result.add(board);
            return;
        }
        for (int c = 0; c < n; c++) {
            int d = row - c + n, a = row + c;
            if (cols[c] || diags[d] || antis[a]) {
                continue;
            }
            placement[row] = c;
            cols[c] = diags[d] = antis[a] = true;

            backtrack(row + 1);

            cols[c] = diags[d] = antis[a] = false;
        }
    }
}
