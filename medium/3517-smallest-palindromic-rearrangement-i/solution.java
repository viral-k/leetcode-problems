/**
 * 3517. Smallest Palindromic Rearrangement I
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public String smallestPalindrome(String s) {
        int[] cnt = new int[26];
        for (int i = 0; i < s.length(); i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        StringBuilder left = new StringBuilder();
        char middle = 0;
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < cnt[c] / 2; k++) {
                left.append((char) ('a' + c));
            }
            if (cnt[c] % 2 == 1) {
                middle = (char) ('a' + c); // the single odd character sits in the center
            }
        }

        String leftHalf = left.toString();
        String rightHalf = left.reverse().toString();
        return middle == 0 ? leftHalf + rightHalf : leftHalf + middle + rightHalf;
    }
}
