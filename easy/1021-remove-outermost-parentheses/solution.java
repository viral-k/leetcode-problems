/**
 * 1021. Remove Outermost Parentheses
 * Time: O(n)
 * Space: O(n) for the output, O(1) beyond it
 */
class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder out = new StringBuilder();
        int depth = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                // outermost when the depth before it is 0
                if (depth > 0) {
                    out.append(ch);
                }
                depth++;
            } else {
                depth--;
                // outermost when the depth after it is 0
                if (depth > 0) {
                    out.append(ch);
                }
            }
        }

        return out.toString();
    }
}
