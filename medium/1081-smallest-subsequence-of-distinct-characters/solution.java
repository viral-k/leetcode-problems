/**
 * 1081. Smallest Subsequence of Distinct Characters
 * Time: O(n)
 * Space: O(26)
 */
class Solution {
    public String smallestSubsequence(String s) {
        int[] last = new int[26]; // last occurrence of each char
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }

        StringBuilder stack = new StringBuilder();
        boolean[] inStack = new boolean[26];

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (inStack[c - 'a']) {
                continue;
            }
            // drop bigger characters that we can still re-add later
            while (stack.length() > 0) {
                char top = stack.charAt(stack.length() - 1);
                if (top > c && last[top - 'a'] > i) {
                    stack.deleteCharAt(stack.length() - 1);
                    inStack[top - 'a'] = false;
                } else {
                    break;
                }
            }
            stack.append(c);
            inStack[c - 'a'] = true;
        }

        return stack.toString();
    }
}
