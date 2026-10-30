import java.util.*;

/**
 * 3970. Shortest Path With At Most K Consecutive Identical Characters
 * Time: O(k * (n + m) log(n * k))
 * Space: O(n * k + m)
 */
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        // Adjacency list in CSR form
        int m = edges.length;
        int[] start = new int[n + 1];
        for (int[] e : edges) {
            start[e[0] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            start[i + 1] += start[i];
        }
        int[] to = new int[m];
        int[] wt = new int[m];
        int[] fill = Arrays.copyOf(start, n);
        for (int[] e : edges) {
            int at = fill[e[0]]++;
            to[at] = e[1];
            wt[at] = e[2];
        }

        // State id = node * K + run, where run is the length of the current
        // streak of identical labels ending at node (1..k).
        int K = k + 1;
        long[] dist = new long[n * K];
        Arrays.fill(dist, Long.MAX_VALUE);
        // best[u] = smallest run already settled at u. A later pop of u with a
        // run at least that long is dominated: more distance, no better run.
        int[] best = new int[n];
        Arrays.fill(best, K);

        PriorityQueue<long[]> heap = new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0]));
        dist[1] = 0;
        heap.add(new long[] {0, 1});
        int target = n - 1;
        while (!heap.isEmpty()) {
            long[] top = heap.poll();
            long d = top[0];
            int s = (int) top[1];
            if (d > dist[s]) {
                continue;
            }
            int u = s / K, r = s % K;
            if (r >= best[u]) {
                continue;
            }
            best[u] = r;
            if (u == target) {
                return (int) d;
            }
            char cu = labels.charAt(u);
            for (int j = start[u]; j < start[u + 1]; j++) {
                int v = to[j];
                int nr = labels.charAt(v) == cu ? r + 1 : 1;
                if (nr > k || nr >= best[v]) {
                    continue;
                }
                int ns = v * K + nr;
                long nd = d + wt[j];
                if (nd < dist[ns]) {
                    dist[ns] = nd;
                    heap.add(new long[] {nd, ns});
                }
            }
        }
        return -1;
    }
}
