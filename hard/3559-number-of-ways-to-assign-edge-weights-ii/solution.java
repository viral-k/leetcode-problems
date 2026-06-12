import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 3559. Number of Ways to Assign Edge Weights II
 * Time: O((n + q) log n)
 * Space: O(n log n)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    private int LOG;
    private int[][] up;
    private int[] depth;

    public int[] assignEdgeWeights(int[][] edges, int[][] queries) {
        int n = edges.length + 1;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        LOG = Math.max(1, 32 - Integer.numberOfLeadingZeros(n));
        up = new int[LOG][n + 1];
        depth = new int[n + 1];

        // BFS from root to set depth and immediate parent (up[0]).
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    depth[neighbor] = depth[node] + 1;
                    up[0][neighbor] = node;
                    queue.offer(neighbor);
                }
            }
        }

        // Binary lifting table.
        for (int k = 1; k < LOG; k++) {
            for (int v = 1; v <= n; v++) {
                up[k][v] = up[k - 1][up[k - 1][v]];
            }
        }

        long[] pow2 = new long[n + 1];
        pow2[0] = 1;
        for (int i = 1; i <= n; i++) {
            pow2[i] = pow2[i - 1] * 2 % MOD;
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0];
            int v = queries[i][1];
            int d = depth[u] + depth[v] - 2 * depth[lca(u, v)];
            answer[i] = d >= 1 ? (int) pow2[d - 1] : 0;
        }

        return answer;
    }

    private int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        int diff = depth[a] - depth[b];
        for (int k = 0; k < LOG; k++) {
            if (((diff >> k) & 1) == 1) {
                a = up[k][a];
            }
        }
        if (a == b) {
            return a;
        }
        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][a] != up[k][b]) {
                a = up[k][a];
                b = up[k][b];
            }
        }
        return up[0][a];
    }
}
