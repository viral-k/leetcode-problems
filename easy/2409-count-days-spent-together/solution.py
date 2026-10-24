class Solution:
    def countDaysTogether(
        self, arriveAlice: str, leaveAlice: str, arriveBob: str, leaveBob: str
    ) -> int:
        """
        2409. Count Days Spent Together
        Time: O(1)
        Space: O(1)
        """
        # cumulative days before each month in a non-leap year
        prefix = [0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334]

        def ordinal(date: str) -> int:
            # fixed width "MM-DD", so slice rather than split
            return prefix[int(date[:2]) - 1] + int(date[3:])

        lo = max(ordinal(arriveAlice), ordinal(arriveBob))
        hi = min(ordinal(leaveAlice), ordinal(leaveBob))

        # closed intervals overlap on [lo, hi]; empty when hi < lo
        return max(0, hi - lo + 1)
