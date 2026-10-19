import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 218. The Skyline Problem
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        // {x, -h, right} for a left edge, {x, 0, 0} for a right edge.
        // Sorting by -h puts starts before ends at a shared x, and taller
        // starts before shorter ones, so no point is emitted off the contour.
        int[][] events = new int[buildings.length * 2][];
        int k = 0;
        for (int[] b : buildings) {
            events[k++] = new int[] {b[0], -b[2], b[1]};
            events[k++] = new int[] {b[1], 0, 0};
        }
        // Integer.compare rather than subtraction: coordinates and heights
        // reach 2^31 - 1, so a - b would overflow.
        Arrays.sort(events, (a, b) -> a[0] != b[0]
                ? Integer.compare(a[0], b[0])
                : Integer.compare(a[1], b[1]));

        // max-heap of {height, right}, with lazy deletion
        PriorityQueue<int[]> live =
                new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        List<List<Integer>> skyline = new ArrayList<>();
        int lastHeight = 0;
        for (int[] event : events) {
            int x = event[0];
            while (!live.isEmpty() && live.peek()[1] <= x) {
                live.poll();  // no longer covers x
            }
            if (event[1] != 0) {
                live.add(new int[] {-event[1], event[2]});
            }

            int current = live.isEmpty() ? 0 : live.peek()[0];
            if (skyline.isEmpty() || lastHeight != current) {
                skyline.add(List.of(x, current));
                lastHeight = current;
            }
        }

        return skyline;
    }
}
