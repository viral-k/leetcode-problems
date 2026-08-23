/**
 * 1927. Sum Game
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean sumGame(String num) {
        int n = num.length();
        int half = n / 2;

        int sumLeft = 0, sumRight = 0;
        int qLeft = 0, qRight = 0;
        for (int i = 0; i < n; i++) {
            char ch = num.charAt(i);
            if (i < half) {
                if (ch == '?') {
                    qLeft++;
                } else {
                    sumLeft += ch - '0';
                }
            } else {
                if (ch == '?') {
                    qRight++;
                } else {
                    sumRight += ch - '0';
                }
            }
        }

        // Odd number of blanks: Alice moves last and can always break equality.
        if ((qLeft + qRight) % 2 == 1) {
            return true;
        }

        // Surplus blanks on one side are worth 9 per pair under optimal play.
        return sumLeft - sumRight != 9 * (qRight - qLeft) / 2;
    }
}
