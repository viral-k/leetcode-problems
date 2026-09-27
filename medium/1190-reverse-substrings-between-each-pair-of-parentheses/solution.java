import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1190. Reverse Substrings Between Each Pair of Parentheses
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public String reverseParentheses(String s) {
        int n = s.length();
        int[] pair = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                stack.push(i);
            } else if (ch == ')') {
                int j = stack.pop();
                pair[i] = j;
                pair[j] = i;
            }
        }

        // each bracket teleports to its partner and flips the reading
        // direction, which is exactly what reversing that group does
        StringBuilder out = new StringBuilder();
        int i = 0;
        int step = 1;
        while (i >= 0 && i < n) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == ')') {
                i = pair[i];
                step = -step;
            } else {
                out.append(ch);
            }
            i += step;
        }

        return out.toString();
    }
}
