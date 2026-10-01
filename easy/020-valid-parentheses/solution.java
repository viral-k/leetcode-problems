import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 20. Valid Parentheses
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            char expected;
            switch (ch) {
                case ')': expected = '('; break;
                case ']': expected = '['; break;
                case '}': expected = '{'; break;
                default:
                    stack.push(ch);
                    continue;
            }
            if (stack.isEmpty() || stack.pop() != expected) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
