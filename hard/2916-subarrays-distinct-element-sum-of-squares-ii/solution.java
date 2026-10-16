import java.util.HashMap;
import java.util.Map;

/**
 * 2916. Subarrays Distinct Element Sum of Squares II
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    private static final long MOD = 1_000_000_007L;

    private int n;
    // Fenwick pair giving range-add / range-sum over D, where
    // D[i] = distinct count of nums[i..j] for the current right end j.
    // These hold exact counts, never residues: the sums feed a
    // multiplication by 2 that has to match the true values.
    private long[] tree1;
    private long[] tree2;

    public int sumCounts(int[] nums) {
        n = nums.length;
        tree1 = new long[n + 2];
        tree2 = new long[n + 2];

        Map<Integer, Integer> last = new HashMap<>();
        long squares = 0;  // sum of D[i]^2 over the active prefix
        long answer = 0;

        for (int j = 0; j < n; j++) {
            int v = nums[j];
            int left = last.getOrDefault(v, -1) + 1;  // counts rise on [left, j]
            int width = j - left + 1;

            // read the old D values before incrementing them
            long before = prefix(j + 1) - (left > 0 ? prefix(left) : 0);
            // (d + 1)^2 = d^2 + 2d + 1, summed over `width` indices
            squares = (squares + 2 * before + width) % MOD;

            rangeAdd(left + 1, j + 1);
            last.put(v, j);
            answer = (answer + squares) % MOD;
        }

        return (int) answer;
    }

    private void add(long[] tree, int i, long delta) {
        for (; i <= n; i += i & -i) {
            tree[i] += delta;
        }
    }

    private long prefix(int i) {
        long s1 = 0, s2 = 0;
        for (int x = i; x > 0; x -= x & -x) {
            s1 += tree1[x];
            s2 += tree2[x];
        }
        return s1 * i - s2;
    }

    /** 1-indexed, inclusive, adds 1 to every position in [lo, hi]. */
    private void rangeAdd(int lo, int hi) {
        add(tree1, lo, 1);
        add(tree1, hi + 1, -1);
        add(tree2, lo, lo - 1);
        add(tree2, hi + 1, -hi);
    }
}
