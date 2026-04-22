import java.util.*;

/**
 * 2452. Words Within Two Edits of Dictionary
 * Time: O(Q * D * N)
 * Space: O(1)
 */
class Solution {
    public List<String> twoEditWords(String[] queries, String[] dictionary) {
        List<String> result = new ArrayList<>();

        for (String query : queries) {
            for (String word : dictionary) {
                if (matches(query, word)) {
                    result.add(query);
                    break;
                }
            }
        }

        return result;
    }

    private boolean matches(String q, String d) {
        int diff = 0;
        for (int i = 0; i < q.length(); i++) {
            if (q.charAt(i) != d.charAt(i)) {
                diff++;
                if (diff > 2) {
                    return false;
                }
            }
        }
        return true;
    }
}
