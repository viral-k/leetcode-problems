/**
 * 788. Rotated Digits
 * Time: O(n log n)
 * Space: O(1)
 */
class Solution {
    public int rotatedDigits(int n) {
        int count = 0;

        for (int num = 1; num <= n; num++) {
            if (isGood(num)) {
                count++;
            }
        }

        return count;
    }

    private boolean isGood(int num) {
        boolean hasChange = false;

        while (num > 0) {
            int digit = num % 10;

            if (digit == 3 || digit == 4 || digit == 7) {
                return false;
            }

            if (digit == 2 || digit == 5 || digit == 6 || digit == 9) {
                hasChange = true;
            }

            num /= 10;
        }

        return hasChange;
    }
}
