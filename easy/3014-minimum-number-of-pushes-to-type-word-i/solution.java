/**
 * 3014. Minimum Number of Pushes to Type Word I
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minimumPushes(String word) {
        int total = 0;
        // Distinct letters: the i-th letter (0-based) costs i / 8 + 1 pushes.
        for (int i = 0; i < word.length(); i++) {
            total += i / 8 + 1;
        }
        return total;
    }
}
