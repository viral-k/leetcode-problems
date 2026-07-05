import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 2492. Minimum Score of a Path Between Two Cities
 * Time: O(n + m)
 * Space: O(n + m)
 */
class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] adj = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] r : roads) {
            adj[r[0]].add(new int[]{r[1], r[2]});
            adj[r[1]].add(new int[]{r[0], r[2]});
        }

        int ans = Integer.MAX_VALUE;
        boolean[] visited = new boolean[n + 1];
        visited[1] = true;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(1);
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int[] nb : adj[u]) {
                ans = Math.min(ans, nb[1]);
                if (!visited[nb[0]]) {
                    visited[nb[0]] = true;
                    dq.add(nb[0]);
                }
            }
        }
        return ans;
    }
}
