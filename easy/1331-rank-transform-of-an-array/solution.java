import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1331. Rank Transform of an Array
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();
        Arrays.sort(sorted);

        // Map each distinct value to its 1-based rank.
        Map<Integer, Integer> rank = new HashMap<>();
        int r = 1;
        for (int v : sorted) {
            if (!rank.containsKey(v)) {
                rank.put(v, r++);
            }
        }

        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = rank.get(arr[i]);
        }
        return result;
    }
}
