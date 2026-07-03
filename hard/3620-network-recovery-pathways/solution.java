import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * 3620. Network Recovery Pathways
 * Time: O((n + m) log m)
 * Space: O(n + m)
 */
class Solution {
    private int n;
    private List<int[]>[] adj;
    private int[] topo;
    private boolean[] online;
    private long k;

    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        this.n = online.length;
        this.online = online;
        this.k = k;

        adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] indeg = new int[n];
        for (int[] e : edges) {
            adj[e[0]].add(new int[]{e[1], e[2]});
            indeg[e[1]]++;
        }

        // Kahn's topological order (computed once, reused across checks).
        topo = new int[n];
        int idx = 0;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        int[] deg = indeg.clone();
        for (int i = 0; i < n; i++) {
            if (deg[i] == 0) {
                dq.add(i);
            }
        }
        while (!dq.isEmpty()) {
            int u = dq.poll();
            topo[idx++] = u;
            for (int[] nb : adj[u]) {
                if (--deg[nb[0]] == 0) {
                    dq.add(nb[0]);
                }
            }
        }

        // Distinct sorted edge costs are the only candidate answers.
        TreeSet<Integer> set = new TreeSet<>();
        for (int[] e : edges) {
            set.add(e[2]);
        }
        if (set.isEmpty() || !feasible(set.first())) {
            return -1;
        }
        Integer[] costs = set.toArray(new Integer[0]);

        int lo = 0, hi = costs.length - 1, ans = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            if (feasible(costs[mid])) {
                ans = costs[mid];
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return ans;
    }

    private boolean feasible(int x) {
        long INF = Long.MAX_VALUE;
        long[] dist = new long[n];
        java.util.Arrays.fill(dist, INF);
        dist[0] = 0;
        for (int u : topo) {
            long du = dist[u];
            if (du == INF || !online[u]) {
                continue;
            }
            for (int[] nb : adj[u]) {
                int v = nb[0], c = nb[1];
                if (c >= x && online[v] && du + c < dist[v]) {
                    dist[v] = du + c;
                }
            }
        }
        return dist[n - 1] <= k;
    }
}
