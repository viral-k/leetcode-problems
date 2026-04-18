/**
 * 3783. Mirror Distance of an Integer
 * Time: O(log n)
 * Space: O(1)
 */
class Solution {
    public int mirrorDistance(int n) {
        long reverseN = reverse(n);
        return (int) Math.abs(n - reverseN);
    }

    private long reverse(int n) {
        long result = 0;
        while (n > 0) {
            result = result * 10 + n % 10;
            n /= 10;
        }
        return result;
    }
}
