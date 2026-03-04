/**
 * 3713. Longest Balanced Substring I
 * Time: O(n²)
 * Space: O(1)
 */
class Solution {
    public int longestBalancedSubstring(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int distinct = 0;
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                if (freq[idx] == 0) {
                    distinct++;
                }
                freq[idx]++;
                maxFreq = Math.max(maxFreq, freq[idx]);

                int len = j - i + 1;
                if (distinct * maxFreq == len) {
                    ans = Math.max(ans, len);
                }
            }
        }

        return ans;
    }
}
