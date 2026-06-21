import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 32. Longest Valid Parentheses
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int longestValidParentheses(String s) {
        int best = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1); // sentinel boundary before any valid run

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i); // unmatched ')', new boundary
                } else {
                    best = Math.max(best, i - stack.peek());
                }
            }
        }

        return best;
    }
}
