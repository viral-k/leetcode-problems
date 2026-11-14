import java.util.*;

/**
 * 3364. Minimum Positive Sum Subarray
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums.get(i);
        }

        // window = multiset of prefix[i] for every allowed start i in [j - r, j - l]
        TreeMap<Integer, Integer> window = new TreeMap<>();
        int best = Integer.MAX_VALUE;
        for (int j = l; j <= n; j++) {
            window.merge(prefix[j - l], 1, Integer::sum);
            if (j - r - 1 >= 0) {
                int old = prefix[j - r - 1];
                if (window.merge(old, -1, Integer::sum) == 0) {
                    window.remove(old);
                }
            }
            // The largest prefix[i] < prefix[j] gives the smallest positive sum.
            Integer below = window.lowerKey(prefix[j]);
            if (below != null) {
                best = Math.min(best, prefix[j] - below);
            }
        }

        return best == Integer.MAX_VALUE ? -1 : best;
    }
}
