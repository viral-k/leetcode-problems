/**
 * 2472. Maximum Number of Non-overlapping Palindrome Substrings
 * Time: O(n * k)
 * Space: O(1)
 */
class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        int count = 0;
        int i = 0;

        while (i + k <= n) {
            // any palindrome of length >= k contains one of length k or k+1,
            // so those are the only candidates; take the earliest-ending one
            if (isPal(s, i, i + k - 1)) {
                count++;
                i += k;
            } else if (i + k < n && isPal(s, i, i + k)) {
                count++;
                i += k + 1;
            } else {
                i++;
            }
        }

        return count;
    }

    /** Inclusive bounds. */
    private boolean isPal(String s, int lo, int hi) {
        while (lo < hi) {
            if (s.charAt(lo) != s.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
