/**
 * 1614. Maximum Nesting Depth of the Parentheses
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxDepth(String s) {
        int depth = 0;
        int best = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                depth++;
                if (depth > best) {
                    best = depth;
                }
            } else if (ch == ')') {
                depth--;
            }
        }
        return best;
    }
}
