class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int, need1: int, need2: int) -> int:
        """
        3789. Minimum Cost to Acquire Required Items
        Time: O(1)
        Space: O(1)
        """

        def total(k: int) -> int:
            # Buy k type 3 items, then fill each remaining need with single items.
            return k * costBoth + max(0, need1 - k) * cost1 + max(0, need2 - k) * cost2

        # total(k) is convex and piecewise linear with breakpoints at need1 and
        # need2, so the minimum is at 0 or one of those breakpoints.
        return min(total(0), total(min(need1, need2)), total(max(need1, need2)))
