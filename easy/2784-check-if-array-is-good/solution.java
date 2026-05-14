import java.util.HashMap;
import java.util.Map;

/**
 * 2784. Check if Array is Good
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public boolean isGood(int[] nums) {
        int n = 0;
        for (int num : nums) {
            n = Math.max(n, num);
        }

        if (nums.length != n + 1) {
            return false;
        }

        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        for (int value = 1; value < n; value++) {
            if (count.getOrDefault(value, 0) != 1) {
                return false;
            }
        }

        return count.getOrDefault(n, 0) == 2;
    }
}
