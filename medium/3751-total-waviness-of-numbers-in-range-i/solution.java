/**
 * 3751. Total Waviness of Numbers in Range I
 * Time: O(R * D)
 * Space: O(D)
 */
class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;

        for (int num = num1; num <= num2; num++) {
            total += waviness(num);
        }

        return total;
    }

    private int waviness(int num) {
        String digits = Integer.toString(num);
        int count = 0;

        for (int index = 1; index < digits.length() - 1; index++) {
            char previousDigit = digits.charAt(index - 1);
            char currentDigit = digits.charAt(index);
            char nextDigit = digits.charAt(index + 1);

            if (
                (previousDigit < currentDigit && currentDigit > nextDigit)
                    || (previousDigit > currentDigit && currentDigit < nextDigit)
            ) {
                count++;
            }
        }

        return count;
    }
}
