/**
 * 856. Score of Parentheses
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int scoreOfParentheses(String s) {
        int total = 0;
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                depth++;
            } else {
                depth--;
                // a "()" core at depth d contributes 2^(d-1); every enclosing
                // pair doubled it, and nothing else contributes anything
                if (s.charAt(i - 1) == '(') {
                    total += 1 << depth;
                }
            }
        }

        return total;
    }
}
