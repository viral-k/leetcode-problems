import java.util.HashMap;
import java.util.Map;

/**
 * 2685. Count the Number of Complete Components
 * Time: O(n + m * alpha(n))
 * Space: O(n)
 */
class Solution {
    private int[] parent;
    private int[] size;

    public int countCompleteComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int[] e : edges) {
            union(e[0], e[1]);
        }

        // Count edges per component root.
        Map<Integer, Integer> edgeCount = new HashMap<>();
        for (int[] e : edges) {
            int r = find(e[0]);
            edgeCount.merge(r, 1, Integer::sum);
        }

        int result = 0;
        for (int v = 0; v < n; v++) {
            if (find(v) == v) { // v is a root
                long k = size[v];
                if (edgeCount.getOrDefault(v, 0) == k * (k - 1) / 2) {
                    result++;
                }
            }
        }
        return result;
    }

    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }

    private void union(int a, int b) {
        int ra = find(a), rb = find(b);
        if (ra != rb) {
            if (size[ra] < size[rb]) {
                int t = ra;
                ra = rb;
                rb = t;
            }
            parent[rb] = ra;
            size[ra] += size[rb];
        }
    }
}
