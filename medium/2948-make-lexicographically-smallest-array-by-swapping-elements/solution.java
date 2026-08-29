import java.util.Arrays;

/**
 * 2948. Make Lexicographically Smallest Array by Swapping Elements
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (a, b) -> nums[a] - nums[b]);

        int[] result = new int[n];
        int start = 0;
        while (start < n) {
            // Extend the group while consecutive sorted values stay within limit.
            int end = start + 1;
            while (end < n && nums[order[end]] - nums[order[end - 1]] <= limit) {
                end++;
            }

            // The group owns these positions and these values; pair them in order.
            int size = end - start;
            int[] indices = new int[size];
            for (int k = 0; k < size; k++) {
                indices[k] = order[start + k];
            }
            Arrays.sort(indices);
            for (int k = 0; k < size; k++) {
                result[indices[k]] = nums[order[start + k]];
            }

            start = end;
        }

        return result;
    }
}
