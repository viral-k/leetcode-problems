import java.util.ArrayList;
import java.util.List;

/**
 * 2089. Find Target Indices After Sorting Array
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        int less = 0;
        int count = 0;
        for (int v : nums) {
            if (v < target) {
                less++;
            } else if (v == target) {
                count++;
            }
        }

        // sorting puts the copies of target in one block starting right after
        // everything smaller than it; larger values cannot shift that block
        List<Integer> result = new ArrayList<>(count);
        for (int i = less; i < less + count; i++) {
            result.add(i);
        }
        return result;
    }
}
