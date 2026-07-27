/**
 * 1464. Maximum Product of Two Elements in an Array
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int maxProduct(int[] nums) {
        int max1 = 0, max2 = 0; // two largest values
        for (int x : nums) {
            if (x >= max1) {
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max2 = x;
            }
        }
        return (max1 - 1) * (max2 - 1);
    }
}
