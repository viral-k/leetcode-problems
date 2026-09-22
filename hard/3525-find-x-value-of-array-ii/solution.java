/**
 * 3525. Find X Value of Array II
 * Time: O((n + q) * k * log n)
 * Space: O(n * k)
 */
class Solution {
    private int k, size;
    private int[] prod;    // product of the node's segment mod k
    private int[][] cnt;   // cnt[node][x] = #non-empty prefixes with product % k == x

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        int n = nums.length;
        size = 1;
        while (size < n) {
            size <<= 1;
        }
        prod = new int[2 * size];
        cnt = new int[2 * size][k];
        java.util.Arrays.fill(prod, 1);  // identity node: prod 1, empty histogram

        for (int i = 0; i < n; i++) {
            int m = nums[i] % k;
            prod[size + i] = m;
            cnt[size + i][m] = 1;
        }
        for (int node = size - 1; node >= 1; node--) {
            pull(node);
        }

        int[] result = new int[queries.length];
        for (int q = 0; q < queries.length; q++) {
            int index = queries[q][0], value = queries[q][1];
            int start = queries[q][2], x = queries[q][3];
            update(index, value);
            result[q] = query(start, n - 1)[x];
        }
        return result;
    }

    /** Recompute node from its two children (left then right). */
    private void pull(int node) {
        int l = 2 * node, r = 2 * node + 1;
        prod[node] = prod[l] * prod[r] % k;
        int[] out = cnt[node];
        System.arraycopy(cnt[l], 0, out, 0, k);
        for (int x = 0; x < k; x++) {
            out[prod[l] * x % k] += cnt[r][x];
        }
    }

    private void update(int pos, int value) {
        int node = size + pos;
        int m = value % k;
        prod[node] = m;
        java.util.Arrays.fill(cnt[node], 0);
        cnt[node][m] = 1;
        for (node >>= 1; node >= 1; node >>= 1) {
            pull(node);
        }
    }

    /** Histogram of prefix residues over nums[lo..hi], folded left to right. */
    private int[] query(int lo, int hi) {
        int lp = 1, rp = 1;
        int[] lc = new int[k], rc = new int[k];
        lo += size;
        hi += size + 1;
        while (lo < hi) {
            if ((lo & 1) == 1) {
                // acc = merge(acc, node)
                for (int x = 0; x < k; x++) {
                    lc[lp * x % k] += cnt[lo][x];
                }
                lp = lp * prod[lo] % k;
                lo++;
            }
            if ((hi & 1) == 1) {
                hi--;
                // acc = merge(node, acc)
                int[] merged = new int[k];
                System.arraycopy(cnt[hi], 0, merged, 0, k);
                for (int x = 0; x < k; x++) {
                    merged[prod[hi] * x % k] += rc[x];
                }
                rc = merged;
                rp = prod[hi] * rp % k;
            }
            lo >>= 1;
            hi >>= 1;
        }
        // final = merge(left acc, right acc)
        for (int x = 0; x < k; x++) {
            lc[lp * x % k] += rc[x];
        }
        return lc;
    }
}
