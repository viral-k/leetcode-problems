import java.util.Arrays;

/**
 * 2790. Maximum Number of Groups With Increasing Length
 * Time: O(n log n)
 * Space: O(1)
 */
class Solution {
    public int maxIncreasingGroups(int[] usageLimits) {
        Arrays.sort(usageLimits);

        long running = 0;
        long groups = 0;

        for (int limit : usageLimits) {
            running += limit;
            if (running >= groups + 1) {
                running -= groups + 1;
                groups += 1;
            }
        }

        return (int) groups;
    }
}
