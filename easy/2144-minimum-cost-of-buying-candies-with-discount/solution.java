import java.util.Arrays;

/**
 * 2144. Minimum Cost of Buying Candies With Discount
 * Time: O(n log n)
 * Space: O(1)
 */
class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);

        int total = 0;
        int positionInGroup = 0;

        for (int index = cost.length - 1; index >= 0; index--) {
            if (positionInGroup != 2) {
                total += cost[index];
            }
            positionInGroup = (positionInGroup + 1) % 3;
        }

        return total;
    }
}
