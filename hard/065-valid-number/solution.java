/**
 * 65. Valid Number
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                seenDigit = true;
            } else if (ch == '+' || ch == '-') {
                // a sign is only legal at the start or right after e/E
                if (i > 0) {
                    char prev = s.charAt(i - 1);
                    if (prev != 'e' && prev != 'E') {
                        return false;
                    }
                }
            } else if (ch == '.') {
                // the exponent must be an integer, so no dot after e/E
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } else if (ch == 'e' || ch == 'E') {
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false; // the exponent needs digits of its own
            } else {
                return false;
            }
        }

        return seenDigit;
    }
}
