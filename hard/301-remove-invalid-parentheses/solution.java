import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 301. Remove Invalid Parentheses
 * Time: O(product of run lengths), far below 2^p after the budget prunes
 * Space: O(n) recursion depth plus the output
 */
class Solution {
    private String s;
    private Set<String> results;

    public List<String> removeInvalidParentheses(String s) {
        this.s = s;
        this.results = new HashSet<>();

        // the exact removal budget: unmatchable ')' and leftover '('
        int extraOpen = 0, extraClose = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                extraOpen++;
            } else if (ch == ')') {
                if (extraOpen > 0) {
                    extraOpen--;
                } else {
                    extraClose++;
                }
            }
        }

        dfs(0, 0, extraOpen, extraClose, new StringBuilder());
        return new ArrayList<>(results);
    }

    private void dfs(int i, int balance, int remOpen, int remClose, StringBuilder built) {
        if (i == s.length()) {
            // both budgets must be spent exactly, or we removed too many
            if (balance == 0 && remOpen == 0 && remClose == 0) {
                results.add(built.toString());
            }
            return;
        }

        char ch = s.charAt(i);
        if (ch != '(' && ch != ')') {
            built.append(ch);
            dfs(i + 1, balance, remOpen, remClose, built);
            built.deleteCharAt(built.length() - 1);
            return;
        }

        // removing the 2nd of "((" gives the same string as removing the 1st,
        // so branch on *how many* to drop from each run of identical brackets
        // rather than on which ones
        int end = i;
        while (end < s.length() && s.charAt(end) == ch) {
            end++;
        }
        int run = end - i;
        int budget = (ch == '(') ? remOpen : remClose;

        for (int drop = 0; drop <= Math.min(run, budget); drop++) {
            int keep = run - drop;
            if (ch == ')' && balance < keep) {
                continue;
            }
            int mark = built.length();
            for (int k = 0; k < keep; k++) {
                built.append(ch);
            }
            if (ch == '(') {
                dfs(end, balance + keep, remOpen - drop, remClose, built);
            } else {
                dfs(end, balance - keep, remOpen, remClose - drop, built);
            }
            built.setLength(mark);
        }
    }
}
