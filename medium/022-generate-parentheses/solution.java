import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * Time: O(C(n) * n) where C(n) is the nth Catalan number
 * Space: O(n) excluding the output
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(new StringBuilder(), 0, 0, n, result);
        return result;
    }

    private void backtrack(StringBuilder buf, int open, int close, int n, List<String> result) {
        if (buf.length() == 2 * n) {
            result.add(buf.toString());
            return;
        }
        // '(' first so the output comes out lexicographically sorted
        if (open < n) {
            buf.append('(');
            backtrack(buf, open + 1, close, n, result);
            buf.deleteCharAt(buf.length() - 1);
        }
        if (close < open) {
            buf.append(')');
            backtrack(buf, open, close + 1, n, result);
            buf.deleteCharAt(buf.length() - 1);
        }
    }
}
