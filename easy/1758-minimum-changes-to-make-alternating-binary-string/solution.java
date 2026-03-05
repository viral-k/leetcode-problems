/**
 * 1758. Minimum Changes To Make Alternating Binary String
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minOperations(String s) {
        int changeStart0 = 0;
        int changeStart1 = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (i % 2 == 0) {
                if (ch != '0') changeStart0++;
                if (ch != '1') changeStart1++;
            } else {
                if (ch != '1') changeStart0++;
                if (ch != '0') changeStart1++;
            }
        }

        return Math.min(changeStart0, changeStart1);
    }
}
