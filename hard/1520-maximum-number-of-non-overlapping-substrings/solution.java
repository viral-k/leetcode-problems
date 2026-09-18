import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1520. Maximum Number of Non-Overlapping Substrings
 * Time: O(26 * n)
 * Space: O(1) beyond the output
 */
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] first = new int[26];
        int[] last = new int[26];
        Arrays.fill(first, -1);
        for (int i = 0; i < n; i++) {
            int c = s.charAt(i) - 'a';
            if (first[c] == -1) {
                first[c] = i;
            }
            last[c] = i;
        }

        // one closed candidate per letter, starting at that letter's first
        // occurrence; dropped if some inner letter forces extension to the left
        List<int[]> candidates = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (first[c] == -1) {
                continue;
            }
            int left = first[c];
            int right = last[c];
            boolean valid = true;
            for (int i = left; i <= right; i++) {
                int x = s.charAt(i) - 'a';
                if (first[x] < left) {
                    valid = false;
                    break;
                }
                right = Math.max(right, last[x]);
            }
            if (valid) {
                candidates.add(new int[]{left, right});
            }
        }

        // candidates are nested or disjoint, so earliest-end greedy picks the
        // most intervals and the innermost ones
        candidates.sort((a, b) -> Integer.compare(a[1], b[1]));
        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int[] iv : candidates) {
            if (iv[0] > prevEnd) {
                result.add(s.substring(iv[0], iv[1] + 1));
                prevEnd = iv[1];
            }
        }
        return result;
    }
}
