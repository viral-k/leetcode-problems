/**
 * 3622. Check Divisibility by Digit Sum and Product
 * Time: O(d)
 * Space: O(1)
 */
class Solution {
    public boolean checkDivisibility(int n) {
        int digitSum = 0;
        int digitProduct = 1;
        for (int x = n; x > 0; x /= 10) {
            int d = x % 10;
            digitSum += d;
            digitProduct *= d;
        }

        // digitSum >= 1 for any positive n, so the divisor is never zero
        return n % (digitSum + digitProduct) == 0;
    }
}
