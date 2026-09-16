/**
 * 1621. Number of Sets of K Non-Overlapping Line Segments
 * Time: O(k log MOD)
 * Space: O(1)
 */
class Solution {
    private static final long MOD = 1_000_000_007L;

    public int numberOfSets(int n, int k) {
        // Shifting segment i's endpoints up by i-1 turns the "shared endpoint
        // allowed" ordering into a strictly increasing one, so the count is
        // C(n + k - 1, 2k): choose 2k distinct positions out of n + k - 1.
        int total = n + k - 1;
        int choose = 2 * k;
        if (choose > total) {
            return 0;
        }

        long result = 1;
        for (int i = 1; i <= choose; i++) {
            result = result * (total - choose + i) % MOD;
            result = result * modInverse(i) % MOD;
        }
        return (int) result;
    }

    /** Fermat's little theorem: a^(MOD-2) is the inverse of a for prime MOD. */
    private long modInverse(long a) {
        long base = a % MOD, exp = MOD - 2, res = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                res = res * base % MOD;
            }
            base = base * base % MOD;
            exp >>= 1;
        }
        return res;
    }
}
