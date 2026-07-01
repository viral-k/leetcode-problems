/**
 * 1358. Number of Substrings Containing All Three Characters
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int numberOfSubstrings(String s) {
        int[] last = {-1, -1, -1}; // last index of a, b, c
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
            int m = Math.min(last[0], Math.min(last[1], last[2]));
            ans += m + 1; // m = -1 until all three seen
        }
        return ans;
    }
}
