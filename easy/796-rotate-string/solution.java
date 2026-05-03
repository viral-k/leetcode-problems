/**
 * 796. Rotate String
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public boolean rotateString(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        String text = s + s;
        int[] lps = buildLps(goal);
        int matched = 0;

        for (int i = 0; i < text.length(); i++) {
            while (matched > 0 && text.charAt(i) != goal.charAt(matched)) {
                matched = lps[matched - 1];
            }

            if (text.charAt(i) == goal.charAt(matched)) {
                matched++;
            }

            if (matched == goal.length()) {
                return true;
            }
        }

        return false;
    }

    private int[] buildLps(String pattern) {
        int[] lps = new int[pattern.length()];
        int length = 0;

        for (int i = 1; i < pattern.length(); i++) {
            while (length > 0 && pattern.charAt(i) != pattern.charAt(length)) {
                length = lps[length - 1];
            }

            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
            }
        }

        return lps;
    }
}
