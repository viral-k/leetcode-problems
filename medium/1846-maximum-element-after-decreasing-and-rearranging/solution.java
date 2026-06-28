import java.util.Arrays;

/**
 * 1846. Maximum Element After Decreasing and Rearranging
 * Time: O(n log n)
 * Space: O(1)
 */
class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        Arrays.sort(arr);
        int prev = 1; // first element must be 1
        for (int i = 1; i < arr.length; i++) {
            // can only decrease, and must stay within +1 of the previous
            prev = Math.min(arr[i], prev + 1);
        }
        return prev;
    }
}
