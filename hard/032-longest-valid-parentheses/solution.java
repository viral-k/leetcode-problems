/**
 * 32. Longest Valid Parentheses
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        int best = 0;

        // left to right: a prefix with more ')' than '(' can never recover,
        // so reset there; equality means the scanned stretch is balanced
        int open = 0, close = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                best = Math.max(best, 2 * close);
            } else if (close > open) {
                open = close = 0;
            }
        }

        // right to left catches runs with leftover unmatched '(' like "(()"
        open = close = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else {
                close++;
            }
            if (open == close) {
                best = Math.max(best, 2 * open);
            } else if (open > close) {
                open = close = 0;
            }
        }

        return best;
    }
}
