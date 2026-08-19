import java.util.HashMap;
import java.util.Map;

/**
 * 1386. Cinema Seat Allocation
 * Time: O(m)
 * Space: O(m)
 */
class Solution {
    private static final int LEFT = 0b0000011110;   // seats 2,3,4,5
    private static final int MIDDLE = 0b0001111000; // seats 4,5,6,7
    private static final int RIGHT = 0b0111100000;  // seats 6,7,8,9

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        // Bit mask of taken seats per row (bit s-1 set means seat s reserved).
        Map<Integer, Integer> taken = new HashMap<>();
        for (int[] r : reservedSeats) {
            taken.merge(r[0], 1 << (r[1] - 1), (a, b) -> a | b);
        }

        long total = 2L * n; // every untouched row seats exactly 2 groups
        for (int mask : taken.values()) {
            boolean leftFree = (mask & LEFT) == 0;
            boolean midFree = (mask & MIDDLE) == 0;
            boolean rightFree = (mask & RIGHT) == 0;

            int value;
            if (leftFree && rightFree) {
                value = 2;
            } else if (leftFree || midFree || rightFree) {
                value = 1;
            } else {
                value = 0;
            }

            total += value - 2; // correct the baseline for this row
        }
        return (int) total;
    }
}
