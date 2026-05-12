import java.util.Arrays;

/**
 * 1665. Minimum Initial Energy to Finish Tasks
 * Time: O(n log n)
 * Space: O(1)
 */
class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) -> (b[1] - b[0]) - (a[1] - a[0]));

        int initial = 0;
        int current = 0;

        for (int[] task : tasks) {
            int actual = task[0];
            int minimum = task[1];

            if (current < minimum) {
                int needed = minimum - current;
                initial += needed;
                current += needed;
            }

            current -= actual;
        }

        return initial;
    }
}
