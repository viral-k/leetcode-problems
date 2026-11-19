/**
 * 2567. Minimum Score by Changing Two Elements
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minimizeSum(int[] nums) {
        // Changed elements copy a value still in the array, so the low score is
        // 0 and the answer is the smallest range left after dropping two
        // extremes. Only the 3 smallest and 3 largest values matter.
        int a0 = Integer.MAX_VALUE, a1 = Integer.MAX_VALUE, a2 = Integer.MAX_VALUE; // a0 <= a1 <= a2
        int b0 = Integer.MIN_VALUE, b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE; // b0 >= b1 >= b2
        for (int x : nums) {
            if (x <= a0) {
                a2 = a1;
                a1 = a0;
                a0 = x;
            } else if (x <= a1) {
                a2 = a1;
                a1 = x;
            } else if (x < a2) {
                a2 = x;
            }
            if (x >= b0) {
                b2 = b1;
                b1 = b0;
                b0 = x;
            } else if (x >= b1) {
                b2 = b1;
                b1 = x;
            } else if (x > b2) {
                b2 = x;
            }
        }
        return Math.min(b0 - a2,      // drop the two smallest
                Math.min(b2 - a0,     // drop the two largest
                        b1 - a1));    // drop one of each
    }
}
