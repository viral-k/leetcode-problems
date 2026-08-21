import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3116. Kth Smallest Amount With Single Denomination Combination
 * Time: O(2^m * log(k * minCoin))
 * Space: O(2^m)
 */
class Solution {
    public long findKthSmallest(int[] coins, int k) {
        // Drop coins that are multiples of another coin: their multiples
        // are already covered, so they add nothing to the union.
        int[] sorted = coins.clone();
        Arrays.sort(sorted);
        List<Integer> base = new ArrayList<>();
        for (int c : sorted) {
            boolean redundant = false;
            for (int d : base) {
                if (c % d == 0) {
                    redundant = true;
                    break;
                }
            }
            if (!redundant) {
                base.add(c);
            }
        }

        int n = base.size();
        long hi = (long) k * base.get(0); // smallest coin alone reaches k multiples by here

        // Inclusion-exclusion terms: lcm paired with sign. Subsets whose lcm
        // exceeds hi always contribute 0, so they are skipped (avoids overflow).
        List<long[]> terms = new ArrayList<>();
        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean keep = true;
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    lcm = lcm / gcd(lcm, base.get(i)) * base.get(i);
                    if (lcm > hi) {
                        keep = false;
                        break;
                    }
                }
            }
            if (keep) {
                long sign = (Integer.bitCount(mask) % 2 == 1) ? 1 : -1;
                terms.add(new long[]{lcm, sign});
            }
        }

        long lo = 1;
        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (count(terms, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    /** How many reachable amounts are <= x. */
    private long count(List<long[]> terms, long x) {
        long total = 0;
        for (long[] t : terms) {
            total += t[1] * (x / t[0]);
        }
        return total;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
