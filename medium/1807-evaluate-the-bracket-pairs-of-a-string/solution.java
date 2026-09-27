import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1807. Evaluate the Bracket Pairs of a String
 * Time: O(n + m)
 * Space: O(n + m)
 */
class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> lookup = new HashMap<>();
        for (List<String> pair : knowledge) {
            lookup.put(pair.get(0), pair.get(1));
        }

        StringBuilder out = new StringBuilder();
        StringBuilder key = new StringBuilder();
        boolean inKey = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                inKey = true;
                key.setLength(0);
            } else if (ch == ')') {
                inKey = false;
                out.append(lookup.getOrDefault(key.toString(), "?"));
            } else if (inKey) {
                key.append(ch);
            } else {
                out.append(ch);
            }
        }

        return out.toString();
    }
}
