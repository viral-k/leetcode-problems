/**
 * 87. Scramble String
 * Time: O(n^4)
 * Space: O(n^3)
 */
class Solution {
    private String s1, s2;
    private Boolean[][][] memo; // [i][j][length], null = not yet computed

    public boolean isScramble(String s1, String s2) {
        int n = s1.length();
        if (n != s2.length()) {
            return false;
        }
        this.s1 = s1;
        this.s2 = s2;
        memo = new Boolean[n][n][n + 1];
        return solve(0, 0, n);
    }

    /** Can s1[i, i+length) scramble into s2[j, j+length)? */
    private boolean solve(int i, int j, int length) {
        if (memo[i][j][length] != null) {
            return memo[i][j][length];
        }

        boolean result;
        if (s1.regionMatches(i, s2, j, length)) {
            result = true;
        } else if (!sameLetters(i, j, length)) {
            result = false; // different letters: no split can work
        } else {
            result = false;
            for (int k = 1; k < length && !result; k++) {
                // halves kept in order
                if (solve(i, j, k) && solve(i + k, j + k, length - k)) {
                    result = true;
                }
                // halves swapped: s1's prefix lands on s2's suffix
                else if (solve(i, j + length - k, k) && solve(i + k, j, length - k)) {
                    result = true;
                }
            }
        }

        memo[i][j][length] = result;
        return result;
    }

    private boolean sameLetters(int i, int j, int length) {
        int[] count = new int[26];
        for (int t = 0; t < length; t++) {
            count[s1.charAt(i + t) - 'a']++;
            count[s2.charAt(j + t) - 'a']--;
        }
        for (int c : count) {
            if (c != 0) {
                return false;
            }
        }
        return true;
    }
}
