/**
 * 233. Number of Digit One
 * Time: O(log n)
 * Space: O(1)
 */
class Solution {
    public int countDigitOne(int n) {
        long count = 0;
        // long: p reaches 10^10 after the last digit of n = 10^9.
        for (long p = 1; p <= n; p *= 10) {
            long high = n / (p * 10), cur = (n / p) % 10, low = n % p;
            // Each full block of 10p numbers has p ones at this position.
            count += high * p;
            // The partial block: before, inside, or past the run of 1s.
            if (cur == 1) {
                count += low + 1;
            } else if (cur > 1) {
                count += p;
            }
        }
        return (int) count;
    }
}
