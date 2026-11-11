/**
 * 3789. Minimum Cost to Acquire Required Items
 * Time: O(1)
 * Space: O(1)
 */
class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        // total(k) is convex and piecewise linear with breakpoints at need1 and
        // need2, so the minimum is at 0 or one of those breakpoints.
        long lo = Math.min(need1, need2), hi = Math.max(need1, need2);
        return Math.min(total(0, cost1, cost2, costBoth, need1, need2),
                Math.min(total(lo, cost1, cost2, costBoth, need1, need2),
                        total(hi, cost1, cost2, costBoth, need1, need2)));
    }

    // Buy k type 3 items, then fill each remaining need with single items.
    private long total(long k, long cost1, long cost2, long costBoth, long need1, long need2) {
        return k * costBoth + Math.max(0, need1 - k) * cost1 + Math.max(0, need2 - k) * cost2;
    }
}
