/**
 * 3514. Number of Unique XOR Triplets II
 * Time: O(D^2 + V * D)  (D = distinct values, V = 2048)
 * Space: O(V)
 */
class Solution {
    private static final int V = 2048; // values <= 1500 < 2^11

    public int uniqueXorTriplets(int[] nums) {
        // Deduplicate.
        boolean[] present = new boolean[V];
        for (int x : nums) {
            present[x] = true;
        }
        int d = 0;
        int[] distinct = new int[V];
        for (int v = 0; v < V; v++) {
            if (present[v]) {
                distinct[d++] = v;
            }
        }

        // All pairwise XORs; a ^ a = 0 covers reusing one index twice.
        boolean[] pairs = new boolean[V];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < d; j++) {
                pairs[distinct[i] ^ distinct[j]] = true;
            }
        }

        // XOR every pair value against every element.
        boolean[] result = new boolean[V];
        for (int p = 0; p < V; p++) {
            if (!pairs[p]) {
                continue;
            }
            for (int i = 0; i < d; i++) {
                result[p ^ distinct[i]] = true;
            }
        }

        int count = 0;
        for (boolean b : result) {
            if (b) {
                count++;
            }
        }
        return count;
    }
}
