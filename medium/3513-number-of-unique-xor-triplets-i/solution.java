/**
 * 3513. Number of Unique XOR Triplets I
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return n; // n=1 -> 1, n=2 -> 2
        }
        // full range [0, 2^B - 1] where B = bit length of n
        int bits = 32 - Integer.numberOfLeadingZeros(n);
        return 1 << bits;
    }
}
