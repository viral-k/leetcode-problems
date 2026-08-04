import java.util.ArrayList;
import java.util.List;

/**
 * 3731. Find Missing Elements
 * Time: O(n + R)  (R = max - min)
 * Space: O(n)
 */
class Solution {
    public int[] missingElements(int[] nums) {
        boolean[] present = new boolean[101]; // values in [1, 100]
        int lo = Integer.MAX_VALUE, hi = Integer.MIN_VALUE;
        for (int x : nums) {
            present[x] = true;
            lo = Math.min(lo, x);
            hi = Math.max(hi, x);
        }

        List<Integer> missing = new ArrayList<>();
        for (int v = lo; v <= hi; v++) {
            if (!present[v]) {
                missing.add(v);
            }
        }

        int[] result = new int[missing.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = missing.get(i);
        }
        return result;
    }
}
