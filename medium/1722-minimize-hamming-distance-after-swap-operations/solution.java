import java.util.*;

/**
 * 1722. Minimize Hamming Distance After Swap Operations
 * Time: O(n * α(n))
 * Space: O(n)
 */
class Solution {
    private int[] parent;
    private int[] rank;

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // Build connected components
        for (int[] swap : allowedSwaps) {
            union(swap[0], swap[1]);
        }

        // Group indices by root
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = find(i);
            groups.computeIfAbsent(root, k -> new ArrayList<>()).add(i);
        }

        // Count unmatched positions
        int hamming = 0;
        for (List<Integer> indices : groups.values()) {
            Map<Integer, Integer> sourceCount = new HashMap<>();
            for (int i : indices) {
                sourceCount.merge(source[i], 1, Integer::sum);
            }

            for (int i : indices) {
                int t = target[i];
                if (sourceCount.getOrDefault(t, 0) > 0) {
                    sourceCount.put(t, sourceCount.get(t) - 1);
                } else {
                    hamming++;
                }
            }
        }

        return hamming;
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private void union(int x, int y) {
        int px = find(x), py = find(y);
        if (px == py) return;

        if (rank[px] < rank[py]) {
            int temp = px;
            px = py;
            py = temp;
        }
        parent[py] = px;
        if (rank[px] == rank[py]) {
            rank[px]++;
        }
    }
}
