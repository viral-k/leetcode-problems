import java.util.*;

/**
 * 2615. Sum of Distances
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];

        // Group indices by value
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // For each group, calculate distances using prefix sum
        for (List<Integer> indices : groups.values()) {
            int count = indices.size();

            // Build prefix sum of indices
            long[] prefix = new long[count + 1];
            for (int j = 0; j < count; j++) {
                prefix[j + 1] = prefix[j] + indices.get(j);
            }

            for (int j = 0; j < count; j++) {
                long idx = indices.get(j);
                // Left contribution
                long left = idx * j - prefix[j];
                // Right contribution
                long right = (prefix[count] - prefix[j + 1]) - idx * (count - j - 1);
                arr[(int) idx] = left + right;
            }
        }

        return arr;
    }
}
