/**
 * 678. Valid Parenthesis String
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean checkValidString(String s) {
        // [lo, hi] = reachable open-bracket counts for the prefix so far
        int lo = 0, hi = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                lo++;
                hi++;
            } else if (ch == ')') {
                lo--;
                hi--;
            } else {  // '*' can be ')', '(' or empty
                lo--;
                hi++;
            }

            if (hi < 0) {
                return false;  // more ')' than any reading can match
            }
            if (lo < 0) {
                lo = 0;  // treat the wildcard as empty instead
            }
        }

        return lo == 0;
    }
}
