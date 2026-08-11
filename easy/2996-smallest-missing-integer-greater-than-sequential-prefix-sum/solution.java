import java.util.HashSet;
import java.util.Set;

/**
 * 2996. Smallest Missing Integer Greater Than Sequential Prefix Sum
 * Time: O(n + A)
 * Space: O(n)
 */
class Solution {
    public int missingInteger(int[] nums) {
        // Longest sequential prefix (must start at index 0).
        int total = nums[0];
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[j - 1] + 1) {
                break;
            }
            total += nums[j];
        }

        Set<Integer> present = new HashSet<>();
        for (int x : nums) {
            present.add(x);
        }

        int x = total;
        while (present.contains(x)) {
            x++;
        }
        return x;
    }
}
