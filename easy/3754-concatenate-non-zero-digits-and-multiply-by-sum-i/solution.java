/**
 * 3754. Concatenate Non-Zero Digits and Multiply by Sum I
 * Time: O(d)
 * Space: O(1)
 */
class Solution {
    public long concatenateAndMultiply(int n) {
        long x = 0;
        long total = 0;
        for (char ch : Integer.toString(n).toCharArray()) {
            int d = ch - '0';
            if (d != 0) {
                x = x * 10 + d;
                total += d;
            }
        }
        return x * total;
    }
}
