/**
 * 921. Minimum Add to Make Parentheses Valid
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;  // unmatched '(' seen so far
        int adds = 0;  // ')' that had nothing to pair with

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else if (open > 0) {
                open--;
            } else {
                adds++;
            }
        }

        // leftover openers each need a ')' appended
        return adds + open;
    }
}
