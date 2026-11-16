/**
 * 1524. Number of Sub-arrays With Odd Sum
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        // Prefix sums seen so far, by parity. The empty prefix (sum 0) is even.
        int even = 1, odd = 0;
        int parity = 0;
        // The count is (odd prefixes) * (even prefixes), at most about (n+1)^2 / 4
        // ≈ 2.5 * 10^9, which overflows int but not long.
        long ans = 0;
        for (int x : arr) {
            parity ^= x & 1;
            // A subarray ending here is odd iff its start prefix has the
            // opposite parity to the current one.
            if (parity == 1) {
                ans += even;
                odd++;
            } else {
                ans += odd;
                even++;
            }
        }
        return (int) (ans % MOD);
    }
}
