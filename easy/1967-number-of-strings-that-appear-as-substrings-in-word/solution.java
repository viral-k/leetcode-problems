/**
 * 1967. Number of Strings That Appear as Substrings in Word
 * Time: O(n * |word| * |pattern|)
 * Space: O(1)
 */
class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int count = 0;
        for (String p : patterns) {
            if (word.contains(p)) {
                count++;
            }
        }
        return count;
    }
}
