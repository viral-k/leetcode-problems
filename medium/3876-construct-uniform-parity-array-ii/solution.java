/**
 * 3876. Construct Uniform Parity Array II
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean canConstruct(int[] nums1) {
        long minOdd = Long.MAX_VALUE;
        long minEven = Long.MAX_VALUE;
        int oddCount = 0;

        for (int x : nums1) {
            if (x % 2 != 0) {
                oddCount++;
                if (x < minOdd) {
                    minOdd = x;
                }
            } else if (x < minEven) {
                minEven = x;
            }
        }

        int evenCount = nums1.length - oddCount;

        // The smallest odd can never flip (nothing odd is below it),
        // so any odd element blocks an all-even result.
        boolean allEven = oddCount == 0;
        // Every even must flip, which needs an odd strictly below it.
        boolean allOdd = evenCount == 0 || (oddCount >= 1 && minOdd < minEven);

        return allEven || allOdd;
    }
}
