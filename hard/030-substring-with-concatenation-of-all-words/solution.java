import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. Substring with Concatenation of All Words
 * Time: O(n * L)
 * Space: O(m * L)
 */
class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        int n = s.length();
        int L = words[0].length();
        int m = words.length;
        if ((long) L * m > n) {
            return result;
        }

        Map<String, Integer> need = new HashMap<>();
        for (String w : words) {
            need.merge(w, 1, Integer::sum);
        }

        // Windows only align to L distinct offsets; scan each track separately.
        for (int offset = 0; offset < L; offset++) {
            Map<String, Integer> window = new HashMap<>();
            int left = offset;
            int count = 0;

            for (int right = offset; right + L <= n; right += L) {
                String word = s.substring(right, right + L);

                if (!need.containsKey(word)) {
                    // No valid window can span an unknown word: restart past it.
                    window.clear();
                    count = 0;
                    left = right + L;
                    continue;
                }

                window.merge(word, 1, Integer::sum);
                count++;

                // Too many copies of this word: shrink from the left.
                while (window.get(word) > need.get(word)) {
                    String lw = s.substring(left, left + L);
                    window.merge(lw, -1, Integer::sum);
                    left += L;
                    count--;
                }

                if (count == m) {
                    result.add(left);
                    // Slide one word forward to look for the next match.
                    String lw = s.substring(left, left + L);
                    window.merge(lw, -1, Integer::sum);
                    left += L;
                    count--;
                }
            }
        }

        return result;
    }
}
