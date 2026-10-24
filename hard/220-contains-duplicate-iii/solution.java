import java.util.HashMap;
import java.util.Map;

/**
 * 220. Contains Duplicate III
 * Time: O(n)
 * Space: O(min(n, indexDiff))
 */
class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        // same bucket => difference at most valueDiff; width fits an int
        // because valueDiff <= 1e9
        int width = valueDiff + 1;
        // bucket id -> its single value, over the live window
        Map<Integer, Integer> buckets = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int v = nums[i];

            if (i > indexDiff) {
                // keep the window at indices [i - indexDiff, i - 1]
                int old = nums[i - indexDiff - 1];
                buckets.remove(Math.floorDiv(old, width));
            }

            // floorDiv, not /, so negatives bucket consistently
            int b = Math.floorDiv(v, width);
            if (buckets.containsKey(b)) {
                return true;
            }
            // a value within valueDiff can only be in an adjacent bucket, and
            // bucket b-1 holds values below b * width <= v, so no abs needed.
            // The difference reaches 2e9, so compare in long.
            Integer lower = buckets.get(b - 1);
            if (lower != null && (long) v - lower <= valueDiff) {
                return true;
            }
            Integer upper = buckets.get(b + 1);
            if (upper != null && (long) upper - v <= valueDiff) {
                return true;
            }

            buckets.put(b, v);
        }

        return false;
    }
}
