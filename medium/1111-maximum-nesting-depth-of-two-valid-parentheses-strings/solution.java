/**
 * 1111. Maximum Nesting Depth of Two Valid Parentheses Strings
 * Time: O(n)
 * Space: O(1) beyond the output
 */
class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n = seq.length();
        int[] answer = new int[n];
        int depth = 0;

        for (int i = 0; i < n; i++) {
            if (seq.charAt(i) == '(') {
                depth++;
                answer[i] = depth % 2;
            } else {
                // read before the decrement so a pair shares its depth
                answer[i] = depth % 2;
                depth--;
            }
        }

        return answer;
    }
}
