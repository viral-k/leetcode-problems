import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * 3310. Remove Methods From Project
 * Time: O(n + m)
 * Space: O(n + m)
 */
class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<Integer>[] adj = new List[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] e : invocations) {
            adj[e[0]].add(e[1]);
        }

        // Mark all methods reachable from k (the suspicious set).
        boolean[] suspicious = new boolean[n];
        suspicious[k] = true;
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        dq.add(k);
        while (!dq.isEmpty()) {
            int u = dq.poll();
            for (int v : adj[u]) {
                if (!suspicious[v]) {
                    suspicious[v] = true;
                    dq.add(v);
                }
            }
        }

        // If any non-suspicious method invokes a suspicious one, we can't remove.
        List<Integer> result = new ArrayList<>();
        for (int[] e : invocations) {
            if (!suspicious[e[0]] && suspicious[e[1]]) {
                for (int i = 0; i < n; i++) {
                    result.add(i);
                }
                return result;
            }
        }

        for (int m = 0; m < n; m++) {
            if (!suspicious[m]) {
                result.add(m);
            }
        }
        return result;
    }
}
