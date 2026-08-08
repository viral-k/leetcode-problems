/**
 * 3302. Find the Lexicographically Smallest Valid Sequence
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length(), m = word2.length();

        // f[i] = # of trailing chars of word2 matchable exactly by word1[i:]
        int[] f = new int[n + 1];
        int k = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (k < m && word1.charAt(i) == word2.charAt(m - 1 - k)) {
                k++;
            }
            f[i] = k;
        }

        int[] res = new int[m];
        int j = 0, i = 0;
        boolean changed = false;
        while (i < n && j < m) {
            if (word1.charAt(i) == word2.charAt(j)) {
                res[j++] = i;
                i++;
            } else if (!changed && f[i + 1] >= m - j - 1) {
                // spend the single change here; the rest still matches exactly
                res[j++] = i;
                i++;
                changed = true;
            } else {
                i++;
            }
        }

        return j == m ? res : new int[0];
    }
}
