import java.util.HashSet;
import java.util.Set;

/**
 * 3471. Find the Largest Almost Missing Integer
 * Time: O(n * k)
 * Space: O(n)
 */
class Solution {
    public int largestInteger(int[] nums, int k) {
        int n = nums.length;
        int[] windows = new int[51]; // value -> number of size-k windows containing it

        for (int i = 0; i + k <= n; i++) {
            // a value repeated inside one window still counts that window once
            Set<Integer> seen = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                seen.add(nums[j]);
            }
            for (int v : seen) {
                windows[v]++;
            }
        }

        for (int v = 50; v >= 0; v--) {
            if (windows[v] == 1) {
                return v;
            }
        }
        return -1;
    }
}
