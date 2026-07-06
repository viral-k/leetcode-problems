import java.util.Arrays;

/**
 * 1288. Remove Covered Intervals
 * Time: O(n log n)
 * Space: O(1)
 */
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // left ascending, right descending on ties (bigger interval first)
        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]);
        int count = 0;
        int maxRight = -1;
        for (int[] iv : intervals) {
            if (iv[1] > maxRight) { // not covered by any previous interval
                count++;
                maxRight = iv[1];
            }
        }
        return count;
    }
}
