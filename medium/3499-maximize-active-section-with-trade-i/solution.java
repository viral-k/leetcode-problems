/**
 * 3499. Maximize Active Section with Trade I
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxActiveSectionsAfterTrade(String s) {
        String t = "1" + s + "1";
        int base = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                base++;
            }
        }

        int bestGain = 0;
        int prevZero = 0; // length of the previous 0-run
        int n = t.length();
        int i = 0;
        while (i < n) {
            if (t.charAt(i) == '0') {
                int j = i;
                while (j < n && t.charAt(j) == '0') {
                    j++;
                }
                int run = j - i;
                if (prevZero > 0) { // adjacent zero-runs -> a valid trade
                    bestGain = Math.max(bestGain, prevZero + run);
                }
                prevZero = run;
                i = j;
            } else {
                i++;
            }
        }

        return base + bestGain;
    }
}
