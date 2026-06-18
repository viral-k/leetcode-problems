class Solution:
    def angleClock(self, hour: int, minutes: int) -> float:
        """
        1344. Angle Between Hands of a Clock
        Time: O(1)
        Space: O(1)
        """
        minute_angle = 6 * minutes
        hour_angle = 30 * (hour % 12) + 0.5 * minutes

        diff = abs(hour_angle - minute_angle)
        return min(diff, 360 - diff)
