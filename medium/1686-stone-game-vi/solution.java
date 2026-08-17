import java.util.Arrays;

/**
 * 1686. Stone Game VI
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public int stoneGameVI(int[] aliceValues, int[] bobValues) {
        int n = aliceValues.length;

        // A stone's importance is the swing it causes: own gain + opponent's denial.
        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) {
            order[i] = i;
        }
        Arrays.sort(order, (x, y) ->
            (bobValues[y] + aliceValues[y]) - (bobValues[x] + aliceValues[x]));

        long alice = 0, bob = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                alice += aliceValues[order[i]];
            } else {
                bob += bobValues[order[i]];
            }
        }

        return Long.compare(alice, bob);
    }
}
