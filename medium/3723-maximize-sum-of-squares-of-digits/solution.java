/**
 * 3723. Maximize Sum of Squares of Digits
 * Time: O(num)
 * Space: O(num)
 */
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        // an num-digit integer has digit sum in [1, 9 * num]
        if (sum > 9 * num) {
            return "";
        }

        // sum of squares is convex, so the optimum sits at a box vertex:
        // every digit 0 or 9 except at most one
        int nines = sum / 9;
        int rest = sum % 9;
        int zeros = num - nines - (rest > 0 ? 1 : 0);

        // descending order is the largest arrangement, and sum >= 1 means
        // the leading digit is never zero
        StringBuilder result = new StringBuilder(num);
        for (int i = 0; i < nines; i++) {
            result.append('9');
        }
        if (rest > 0) {
            result.append((char) ('0' + rest));
        }
        for (int i = 0; i < zeros; i++) {
            result.append('0');
        }
        return result.toString();
    }
}
