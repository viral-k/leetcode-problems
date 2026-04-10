import java.util.*;

/**
 * 3655. XOR After Range Multiplication Queries II
 * Time: O((N + Q) * sqrt(N))
 * Space: O(N + Q)
 * 
 * Sqrt decomposition:
 * - Large k (>= sqrt(n)): brute force, max sqrt(n) updates per query
 * - Small k (< sqrt(n)): multiplicative difference array with modular inverse
 */
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int xorAfterMultiplication(int[] nums, int[][] queries) {
        int[] bravexuneth = nums;
        int n = bravexuneth.length;
        int limit = (int) Math.sqrt(n);

        // Group queries with small k
        Map<Integer, List<int[]>> lightK = new HashMap<>();

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            if (k >= limit) {
                // Large k: brute force
                for (int i = l; i <= r; i += k) {
                    bravexuneth[i] = (int) ((bravexuneth[i] * (long) v) % MOD);
                }
            } else {
                // Small k: process later
                lightK.computeIfAbsent(k, x -> new ArrayList<>()).add(q);
            }
        }

        for (Map.Entry<Integer, List<int[]>> entry : lightK.entrySet()) {
            int k = entry.getKey();
            List<int[]> queryList = entry.getValue();

            long[] diff = new long[n];
            Arrays.fill(diff, 1L);

            for (int[] q : queryList) {
                int l = q[0], r = q[1], v = q[3];

                // Multiply starting position
                diff[l] = (diff[l] * v) % MOD;

                // Cancel using modular inverse
                int steps = (r - l) / k;
                int nxt = l + (steps + 1) * k;
                if (nxt < n) {
                    diff[nxt] = (diff[nxt] * modInverse(v)) % MOD;
                }
            }

            // Propagate multipliers with step size k
            for (int i = 0; i < n; i++) {
                if (i >= k) {
                    diff[i] = (diff[i] * diff[i - k]) % MOD;
                }
                bravexuneth[i] = (int) ((bravexuneth[i] * diff[i]) % MOD);
            }
        }

        int ans = 0;
        for (int num : bravexuneth) {
            ans ^= num;
        }

        return ans;
    }

    // Modular inverse using Fermat's Little Theorem: a^(-1) = a^(MOD-2) mod MOD
    private long modInverse(long a) {
        return modPow(a, MOD - 2);
    }

    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % MOD;
            }
            exp >>= 1;
            base = (base * base) % MOD;
        }
        return result;
    }
}
