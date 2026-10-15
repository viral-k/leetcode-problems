/**
 * 214. Shortest Palindrome
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public String shortestPalindrome(String s) {
        if (s.isEmpty()) {
            return "";
        }

        String reversed = new StringBuilder(s).reverse().toString();
        // the '#' is absent from the alphabet, so no border can straddle it
        // and the final prefix value is capped at s.length()
        String t = s + "#" + reversed;
        int n = t.length();

        // pi[i] = longest proper prefix of t[0..i] that is also its suffix
        int[] pi = new int[n];
        int k = 0;
        for (int i = 1; i < n; i++) {
            while (k > 0 && t.charAt(i) != t.charAt(k)) {
                k = pi[k - 1];
            }
            if (t.charAt(i) == t.charAt(k)) {
                k++;
            }
            pi[i] = k;
        }

        // pi[n-1] = longest prefix of s that is also a suffix of reversed s,
        // i.e. the longest palindromic prefix of s
        int longestPalPrefix = pi[n - 1];
        return reversed.substring(0, s.length() - longestPalPrefix) + s;
    }
}
