import java.util.*;

/**
 * 3411. Maximum Subarray With Equal Products
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    private static final int[] PRIMES = {2, 3, 5, 7};

    public int maxLength(int[] nums) {
        // Any pair satisfies a * b == gcd * lcm. For 3 or more elements the
        // condition holds exactly when they are pairwise coprime.
        int[] last = new int[PRIMES.length]; // last index divisible by each prime
        Arrays.fill(last, -1);
        int best = 2;
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < PRIMES.length; j++) {
                if (nums[i] % PRIMES[j] == 0) {
                    left = Math.max(left, last[j] + 1);
                    last[j] = i;
                }
            }
            best = Math.max(best, i - left + 1);
        }
        return best;
    }
}
