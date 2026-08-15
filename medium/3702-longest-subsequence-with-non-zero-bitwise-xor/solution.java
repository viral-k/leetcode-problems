/**
 * 3702. Longest Subsequence With Non-Zero Bitwise XOR
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int longestSubsequence(int[] nums) {
        int total = 0;
        boolean hasNonZero = false;
        for (int x : nums) {
            total ^= x;
            if (x != 0) {
                hasNonZero = true;
            }
        }

        if (total != 0) {
            return nums.length;      // whole array works
        }
        if (hasNonZero) {
            return nums.length - 1;  // drop one non-zero element
        }
        return 0;                    // all zeros: no valid subsequence
    }
}
