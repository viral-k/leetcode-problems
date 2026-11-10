/**
 * 3693. Climbing Stairs II
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int climbStairs(int n, int[] costs) {
        // Large enough to lose every min, small enough that adding 9 can't overflow.
        final int INF = Integer.MAX_VALUE / 2;
        // a, b, c = best cost to reach steps j - 3, j - 2, j - 1. Steps below 0
        // don't exist.
        int a = INF, b = INF, c = 0;
        for (int cost : costs) {
            int next = cost + Math.min(c + 1, Math.min(b + 4, a + 9));
            a = b;
            b = c;
            c = next;
        }
        return c;
    }
}
