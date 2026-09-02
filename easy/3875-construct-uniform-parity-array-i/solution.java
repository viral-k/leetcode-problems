/**
 * 3875. Construct Uniform Parity Array I
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean canConstruct(int[] nums1) {
        int odd = 0;
        for (int x : nums1) {
            if (x % 2 != 0) {
                odd++;
            }
        }
        int even = nums1.length - odd;

        // An odd element must flip parity, needing another odd at a different index.
        boolean allEven = odd != 1;
        // An even element must flip parity, needing any odd element.
        boolean allOdd = even == 0 || odd >= 1;

        return allEven || allOdd;
    }
}
