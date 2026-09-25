import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * 1096. Brace Expansion II
 * Time: O(total output size * word length)
 * Space: O(total output size)
 */
class Solution {
    private String expr;
    private int pos;

    public List<String> braceExpansionII(String expression) {
        expr = expression;
        pos = 0;
        return new ArrayList<>(new TreeSet<>(parseUnion()));
    }

    /** union := concat (',' concat)* */
    private Set<String> parseUnion() {
        Set<String> words = parseConcat();
        while (pos < expr.length() && expr.charAt(pos) == ',') {
            pos++;  // skip ','
            words.addAll(parseConcat());
        }
        return words;
    }

    /** concat := term+ */
    private Set<String> parseConcat() {
        Set<String> words = new HashSet<>();
        words.add("");
        while (pos < expr.length() && expr.charAt(pos) != ',' && expr.charAt(pos) != '}') {
            Set<String> part = parseTerm();
            Set<String> merged = new HashSet<>();
            for (String a : words) {
                for (String b : part) {
                    merged.add(a + b);
                }
            }
            words = merged;
        }
        return words;
    }

    /** term := letter | '{' union '}' */
    private Set<String> parseTerm() {
        if (expr.charAt(pos) == '{') {
            pos++;  // skip '{'
            Set<String> words = parseUnion();
            pos++;  // skip '}'
            return words;
        }
        Set<String> single = new HashSet<>();
        single.add(String.valueOf(expr.charAt(pos)));
        pos++;
        return single;
    }
}
