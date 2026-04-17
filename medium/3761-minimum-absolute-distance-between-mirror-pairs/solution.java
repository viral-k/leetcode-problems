import java.util.*;

/**
 * 3761. Minimum Absolute Distance Between Mirror Pairs
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int minDistance(int[] nums) {
        int n = nums.length;
        int minDist = Integer.MAX_VALUE;

        // Map: value -> smallest index seen (processing right to left)
        Map<Long, Integer> valueToIdx = new HashMap<>();

        for (int i = n - 1; i >= 0; i--) {
            long target = reverse(nums[i]);

            // Check if target exists at some j > i
            if (valueToIdx.containsKey(target)) {
                minDist = Math.min(minDist, valueToIdx.get(target) - i);
            }

            // Store this value with current index
            valueToIdx.put((long) nums[i], i);
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }

    private long reverse(int x) {
        long result = 0;
        while (x > 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }
}
