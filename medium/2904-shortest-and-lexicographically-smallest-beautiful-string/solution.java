import java.util.ArrayList;
import java.util.List;

/**
 * 2904. Shortest and Lexicographically Smallest Beautiful String
 * Time: O(n^2)
 * Space: O(n)
 */
class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        // A beautiful substring can always be trimmed to start and end on a '1',
        // so only windows of k consecutive ones matter.
        List<Integer> ones = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones.add(i);
            }
        }
        if (ones.size() < k) {
            return "";
        }

        String best = "";
        for (int i = 0; i + k - 1 < ones.size(); i++) {
            int start = ones.get(i), end = ones.get(i + k - 1);
            String candidate = s.substring(start, end + 1);
            if (best.isEmpty()
                    || candidate.length() < best.length()
                    || (candidate.length() == best.length() && candidate.compareTo(best) < 0)) {
                best = candidate;
            }
        }
        return best;
    }
}
