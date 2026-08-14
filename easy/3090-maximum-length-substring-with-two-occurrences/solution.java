/**
 * 3090. Maximum Length Substring With Two Occurrences
 * Time: O(n)
 * Space: O(26)
 */
class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int left = 0, best = 0;

        for (int r = 0; r < s.length(); r++) {
            int c = s.charAt(r) - 'a';
            count[c]++;
            // only the just-added character can exceed the limit
            while (count[c] > 2) {
                count[s.charAt(left) - 'a']--;
                left++;
            }
            best = Math.max(best, r - left + 1);
        }

        return best;
    }
}
