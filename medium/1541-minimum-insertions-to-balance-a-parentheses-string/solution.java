/**
 * 1541. Minimum Insertions to Balance a Parentheses String
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int open = 0;  // '(' still awaiting their '))'
        int adds = 0;
        int i = 0;

        while (i < n) {
            if (s.charAt(i) == '(') {
                open++;
                i++;
                continue;
            }

            // consume one closer, which is two ')' wide
            if (i + 1 < n && s.charAt(i + 1) == ')') {
                i += 2;
            } else {
                adds++;  // the second ')' is missing
                i++;
            }

            if (open > 0) {
                open--;
            } else {
                adds++;  // no '(' pending, so one must go before this closer
            }
        }

        // every leftover '(' still needs a full '))'
        return adds + 2 * open;
    }
}
