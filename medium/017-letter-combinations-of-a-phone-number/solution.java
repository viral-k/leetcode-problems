import java.util.ArrayList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 * Time: O(4^n * n)
 * Space: O(n) recursion depth (excluding output)
 */
class Solution {
    private static final String[] MAPPING = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String digits, int idx, StringBuilder path, List<String> result) {
        if (idx == digits.length()) {
            result.add(path.toString());
            return;
        }
        String letters = MAPPING[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            backtrack(digits, idx + 1, path, result);
            path.deleteCharAt(path.length() - 1);
        }
    }
}
