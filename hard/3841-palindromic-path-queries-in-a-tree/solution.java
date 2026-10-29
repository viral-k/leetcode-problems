import java.util.*;

/**
 * 3841. Palindromic Path Queries in a Tree
 * Time: O((n + q) log n)
 * Space: O(n log n)
 */
class Solution {
    private int n, log;
    private int[] depth, tin, tout, base, ch, tree;
    private int[][] up;

    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        this.n = n;

        // Adjacency list in CSR form
        int[] deg = new int[n + 1];
        for (int[] e : edges) {
            deg[e[0] + 1]++;
            deg[e[1] + 1]++;
        }
        for (int i = 0; i < n; i++) {
            deg[i + 1] += deg[i];
        }
        int[] adj = new int[2 * (n - 1)];
        int[] fill = Arrays.copyOf(deg, n);
        for (int[] e : edges) {
            adj[fill[e[0]]++] = e[1];
            adj[fill[e[1]]++] = e[0];
        }

        ch = new int[n];
        for (int i = 0; i < n; i++) {
            ch[i] = 1 << (s.charAt(i) - 'a');
        }

        // Iterative preorder DFS from node 0. base[x] = parity mask root..x.
        int[] parent = new int[n];
        depth = new int[n];
        base = new int[n];
        tin = new int[n];
        int[] order = new int[n];
        boolean[] seen = new boolean[n];
        int[] stack = new int[n];
        int top = 0, idx = 0;
        seen[0] = true;
        base[0] = ch[0];
        stack[top++] = 0;
        while (top > 0) {
            int u = stack[--top];
            tin[u] = idx;
            order[idx++] = u;
            for (int j = deg[u]; j < deg[u + 1]; j++) {
                int w = adj[j];
                if (!seen[w]) {
                    seen[w] = true;
                    parent[w] = u;
                    depth[w] = depth[u] + 1;
                    base[w] = base[u] ^ ch[w];
                    stack[top++] = w;
                }
            }
        }

        int[] size = new int[n];
        Arrays.fill(size, 1);
        for (int i = n - 1; i > 0; i--) {
            int u = order[i];
            size[parent[u]] += size[u];
        }
        tout = new int[n];
        for (int u = 0; u < n; u++) {
            tout[u] = tin[u] + size[u] - 1;
        }

        // Binary lifting: up[k][x] is the 2^k-th ancestor of x (root maps to itself).
        log = Math.max(1, 32 - Integer.numberOfLeadingZeros(n - 1));
        up = new int[log][];
        up[0] = parent;
        for (int k = 1; k < log; k++) {
            up[k] = new int[n];
            for (int x = 0; x < n; x++) {
                up[k][x] = up[k - 1][up[k - 1][x]];
            }
        }

        // Fenwick tree of XOR deltas over preorder positions (1-indexed).
        tree = new int[n + 1];

        List<Boolean> answer = new ArrayList<>();
        for (String q : queries) {
            String[] parts = q.split(" ");
            if (parts[0].equals("update")) {
                int x = Integer.parseInt(parts[1]);
                int next = 1 << (parts[2].charAt(0) - 'a');
                int d = ch[x] ^ next;
                if (d != 0) {
                    ch[x] = next;
                    add(tin[x], d);
                    if (tout[x] + 1 < n) {
                        add(tout[x] + 1, d);
                    }
                }
            } else {
                int u = Integer.parseInt(parts[1]);
                int v = Integer.parseInt(parts[2]);
                int mask = maskOf(u) ^ maskOf(v) ^ ch[lca(u, v)];
                answer.add((mask & (mask - 1)) == 0);
            }
        }
        return answer;
    }

    private void add(int i, int d) {
        for (i++; i <= n; i += i & -i) {
            tree[i] ^= d;
        }
    }

    private int maskOf(int x) {
        int m = base[x];
        for (int i = tin[x] + 1; i > 0; i -= i & -i) {
            m ^= tree[i];
        }
        return m;
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int t = u;
            u = v;
            v = t;
        }
        int diff = depth[u] - depth[v];
        for (int k = 0; diff > 0; k++, diff >>= 1) {
            if ((diff & 1) != 0) {
                u = up[k][u];
            }
        }
        if (u == v) {
            return u;
        }
        for (int k = log - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }
        return up[0][u];
    }
}
