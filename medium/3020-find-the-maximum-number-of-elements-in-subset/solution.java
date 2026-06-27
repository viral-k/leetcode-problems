import java.util.HashMap;
import java.util.Map;

/**
 * 3020. Find the Maximum Number of Elements in Subset
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int maximumLength(int[] nums) {
        Map<Long, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.merge((long) num, 1, Integer::sum);
        }

        int ans = 1;

        // Base 1 is special: 1^2 = 1, so the chain is all ones; length must be odd.
        Integer ones = freq.get(1L);
        if (ones != null) {
            ans = Math.max(ans, (ones % 2 == 1) ? ones : ones - 1);
        }

        for (long x : freq.keySet()) {
            if (x == 1L) {
                continue;
            }
            int count = 0;
            long cur = x;
            while (freq.getOrDefault(cur, 0) >= 2) {
                count += 2;
                cur *= cur;
            }
            // cur now has < 2 copies: use one as the peak, else drop a level.
            count += (freq.getOrDefault(cur, 0) >= 1) ? 1 : -1;
            ans = Math.max(ans, count);
        }

        return ans;
    }
}
