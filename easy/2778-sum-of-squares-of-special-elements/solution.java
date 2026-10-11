/**
 * 2778. Sum of Squares of Special Elements
 * Time: O(sqrt(n))
 * Space: O(1)
 */
class Solution {
    public int sumOfSquares(int[] nums) {
        int n = nums.length;
        int total = 0;

        // the special positions are exactly the divisors of n, so enumerate
        // those in pairs rather than scanning every index
        for (int i = 1; i * i <= n; i++) {
            if (n % i != 0) {
                continue;
            }
            total += nums[i - 1] * nums[i - 1];  // statement is 1-indexed
            int j = n / i;
            if (j != i) {
                total += nums[j - 1] * nums[j - 1];
            }
        }

        return total;
    }
}
