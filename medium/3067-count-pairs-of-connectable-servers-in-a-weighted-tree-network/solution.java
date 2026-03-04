import java.util.ArrayList;
import java.util.List;

/**
 * 3067. Count Pairs of Connectable Servers in a Weighted Tree Network
 * Time: O(n²)
 * Space: O(n)
 */
class Solution {
    private List<int[]>[] graph;
    private int signalSpeed;

    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        this.signalSpeed = signalSpeed;

        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            graph[e[1]].add(new int[]{e[0], e[2]});
        }

        int[] result = new int[n];

        for (int c = 0; c < n; c++) {
            List<Integer> branchCounts = new ArrayList<>();

            for (int[] nei : graph[c]) {
                branchCounts.add(dfs(nei[0], c, nei[1]));
            }

            int total = 0;
            int prefix = 0;
            for (int cnt : branchCounts) {
                total += prefix * cnt;
                prefix += cnt;
            }

            result[c] = total;
        }

        return result;
    }

    private int dfs(int node, int parent, int dist) {
        int count = (dist % signalSpeed == 0) ? 1 : 0;

        for (int[] nei : graph[node]) {
            if (nei[0] == parent) continue;
            count += dfs(nei[0], node, dist + nei[1]);
        }

        return count;
    }
}
