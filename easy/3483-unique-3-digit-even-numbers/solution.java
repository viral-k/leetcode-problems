/**
 * 3483. Unique 3-Digit Even Numbers
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    public int totalNumbers(int[] digits) {
        int[] counts = new int[10];
        for (int d : digits) {
            counts[d]++;
        }

        int total = 0;
        for (int h = 1; h <= 9; h++) { // no leading zero
            if (counts[h] == 0) {
                continue;
            }
            counts[h]--;
            for (int t = 0; t <= 9; t++) {
                if (counts[t] == 0) {
                    continue;
                }
                counts[t]--;
                for (int u = 0; u <= 8; u += 2) { // must be even
                    if (counts[u] > 0) {
                        total++;
                    }
                }
                counts[t]++;
            }
            counts[h]++;
        }

        return total;
    }
}
