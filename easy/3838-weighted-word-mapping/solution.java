/**
 * 3838. Weighted Word Mapping
 * Time: O(L) over all characters
 * Space: O(w) for the output
 */
class Solution {
    public String weightedWordMapping(String[] words, int[] weights) {
        StringBuilder result = new StringBuilder();

        for (String word : words) {
            int total = 0;
            for (int i = 0; i < word.length(); i++) {
                total += weights[word.charAt(i) - 'a'];
            }
            int r = total % 26;
            result.append((char) ('z' - r));
        }

        return result.toString();
    }
}
