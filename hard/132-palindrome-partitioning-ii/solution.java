/**
 * 132. Palindrome Partitioning II
 * Time: O(n^2)
 * Space: O(n^2)
 */
class Solution {
    public int minCut(String s) {
        int n = s.length();
        boolean[][] isPal = new boolean[n][n];

        // expand around each of the 2n-1 centers; every true cell written once
        for (int center = 0; center < 2 * n - 1; center++) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
                isPal[left][right] = true;
                left--;
                right++;
            }
        }

        final int INF = Integer.MAX_VALUE;
        // cuts[i] = min cuts for s[i..]; the -1 sentinel makes a palindromic
        // suffix reaching the end cost 1 + (-1) = 0
        int[] cuts = new int[n + 1];
        java.util.Arrays.fill(cuts, INF);
        cuts[n] = -1;

        for (int i = n - 1; i >= 0; i--) {
            int best = INF;
            for (int j = i; j < n; j++) {
                if (isPal[i][j] && cuts[j + 1] + 1 < best) {
                    best = cuts[j + 1] + 1;
                }
            }
            cuts[i] = best;
        }

        return cuts[0];
    }
}
