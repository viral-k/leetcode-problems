/**
 * 2914. Minimum Number of Changes to Make Binary String Beautiful
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minChanges(String s) {
        // Beautiful <=> every aligned pair (s[2i], s[2i+1]) is equal, and each
        // mismatched pair costs exactly one change.
        int changes = 0;
        for (int i = 0; i < s.length(); i += 2) {
            if (s.charAt(i) != s.charAt(i + 1)) {
                changes++;
            }
        }
        return changes;
    }
}
