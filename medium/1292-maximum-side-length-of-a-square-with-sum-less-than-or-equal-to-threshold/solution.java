/**
 * 1292. Maximum Side Length of a Square with Sum Less than or Equal to Threshold
 * Time: O(m × n × log(min(m, n)))
 * Space: O(m × n)
 */
class Solution {
    private int[][] pref;
    private int m, n, threshold;

    public int maxSideLength(int[][] mat, int threshold) {
        this.m = mat.length;
        this.n = mat[0].length;
        this.threshold = threshold;

        pref = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                pref[i][j] = mat[i - 1][j - 1]
                           + pref[i - 1][j]
                           + pref[i][j - 1]
                           - pref[i - 1][j - 1];
            }
        }

        int low = 0, high = Math.min(m, n);
        int ans = 0;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (possible(mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean possible(int L) {
        for (int i = 0; i <= m - L; i++) {
            for (int j = 0; j <= n - L; j++) {
                int total = pref[i + L][j + L]
                          - pref[i][j + L]
                          - pref[i + L][j]
                          + pref[i][j];
                if (total <= threshold) {
                    return true;
                }
            }
        }
        return false;
    }
}
