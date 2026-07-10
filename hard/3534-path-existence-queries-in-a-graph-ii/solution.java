import java.util.Arrays;

/**
 * 3534. Path Existence Queries in a Graph II
 * Time: O((n + q) log n)
 * Space: O(n log n)
 */
class Solution {
    public int[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Sort nodes by value; rank[node] = its position in sorted order.
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> nums[a] - nums[b]);
        int[] vals = new int[n];
        int[] rank = new int[n];
        for (int k = 0; k < n; k++) {
            vals[k] = nums[order[k]];
            rank[order[k]] = k;
        }

        // R[i] = farthest sorted index reachable in one hop from i.
        int[] R = new int[n];
        int j = 0;
        for (int i = 0; i < n; i++) {
            if (j < i) {
                j = i;
            }
            while (j + 1 < n && vals[j + 1] - vals[i] <= maxDiff) {
                j++;
            }
            R[i] = j;
        }

        // Component ids via consecutive gaps.
        int[] comp = new int[n];
        for (int i = 1; i < n; i++) {
            comp[i] = comp[i - 1] + (vals[i] - vals[i - 1] > maxDiff ? 1 : 0);
        }

        // Binary lifting on the farthest-jump function.
        int LOG = Math.max(1, 32 - Integer.numberOfLeadingZeros(Math.max(1, n)));
        int[][] up = new int[LOG][n];
        up[0] = R;
        for (int k = 1; k < LOG; k++) {
            for (int i = 0; i < n; i++) {
                up[k][i] = up[k - 1][up[k - 1][i]];
            }
        }

        int[] ans = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int su = rank[queries[q][0]], sv = rank[queries[q][1]];
            if (su > sv) {
                int t = su;
                su = sv;
                sv = t;
            }
            if (su == sv) {
                ans[q] = 0;
            } else if (comp[su] != comp[sv]) {
                ans[q] = -1;
            } else {
                int cur = su, steps = 0;
                for (int k = LOG - 1; k >= 0; k--) {
                    if (up[k][cur] < sv) {
                        cur = up[k][cur];
                        steps += 1 << k;
                    }
                }
                ans[q] = steps + 1; // one final jump reaches sv
            }
        }
        return ans;
    }
}
