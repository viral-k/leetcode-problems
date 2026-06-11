import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 3558. Number of Ways to Assign Edge Weights I
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    private static final int MOD = 1_000_000_007;

    public int assignEdgeWeights(int[][] edges) {
        int n = edges.length + 1;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        // BFS from the root (node 1) to find the maximum depth in edges.
        int maxDepth = 0;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[] {1, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int node = current[0];
            int depth = current[1];
            maxDepth = Math.max(maxDepth, depth);
            for (int neighbor : adj.get(node)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[] {neighbor, depth + 1});
                }
            }
        }

        return (int) modPow(2, maxDepth - 1, MOD);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = result * base % mod;
            }
            base = base * base % mod;
            exp >>= 1;
        }
        return result;
    }
}
