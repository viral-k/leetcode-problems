/**
 * 3312. Sorted GCD Pair Queries
 * Time: O(V log V + q log V)
 * Space: O(V)
 */
class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int V = 0;
        for (int x : nums) {
            V = Math.max(V, x);
        }
        int[] cnt = new int[V + 1];
        for (int x : nums) {
            cnt[x]++;
        }

        // multiples[g] = how many elements are divisible by g (harmonic sieve).
        long[] multiples = new long[V + 1];
        for (int g = 1; g <= V; g++) {
            for (int m = g; m <= V; m += g) {
                multiples[g] += cnt[m];
            }
        }

        // f[g] = pairs with gcd exactly g, via inclusion-exclusion from the top.
        long[] f = new long[V + 1];
        for (int g = V; g >= 1; g--) {
            long total = multiples[g] * (multiples[g] - 1) / 2; // gcd divisible by g
            for (int m = 2 * g; m <= V; m += g) {
                total -= f[m];
            }
            f[g] = total;
        }

        // prefix[g] = number of sorted gcdPairs entries that are <= g.
        long[] prefix = new long[V + 1];
        for (int g = 1; g <= V; g++) {
            prefix[g] = prefix[g - 1] + f[g];
        }

        // Query index q -> smallest g with prefix[g] > q.
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = upperBound(prefix, queries[i]);
        }
        return ans;
    }

    /** First index whose prefix value is strictly greater than target. */
    private int upperBound(long[] prefix, long target) {
        int lo = 0, hi = prefix.length - 1;
        while (lo < hi) {
            int mid = (lo + hi) >>> 1;
            if (prefix[mid] > target) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
