/**
 * 3550. Smallest Index With Digit Sum Equal to Index
 * Time: O(n * d)
 * Space: O(1)
 */
class Solution {
    public int smallestIndex(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];
            int digitSum = 0;
            while (v > 0) {
                digitSum += v % 10;
                v /= 10;
            }
            if (digitSum == i) {
                return i;
            }
        }
        return -1;
    }
}
