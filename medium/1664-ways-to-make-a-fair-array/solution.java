/**
 * 1664. Ways to Make a Fair Array
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        long totalEven = 0, totalOdd = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                totalEven += nums[i];
            } else {
                totalOdd += nums[i];
            }
        }

        long preEven = 0, preOdd = 0;
        int count = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            long sufEven, sufOdd;
            if (i % 2 == 0) {
                sufEven = totalEven - preEven - x;
                sufOdd = totalOdd - preOdd;
            } else {
                sufEven = totalEven - preEven;
                sufOdd = totalOdd - preOdd - x;
            }
            // removal flips suffix parity
            if (preEven + sufOdd == preOdd + sufEven) {
                count++;
            }
            if (i % 2 == 0) {
                preEven += x;
            } else {
                preOdd += x;
            }
        }
        return count;
    }
}
