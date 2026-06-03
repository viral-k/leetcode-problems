from bisect import bisect_right
from typing import List


class RideOptions:
    def __init__(self, start_times: List[int], durations: List[int]) -> None:
        rides = sorted(zip(start_times, durations))
        n = len(rides)

        self.starts = [start for start, _ in rides]
        self.prefix_min_duration = [0] * n
        self.suffix_min_finish = [0] * n

        best_duration = float("inf")
        for index, (_, duration) in enumerate(rides):
            best_duration = min(best_duration, duration)
            self.prefix_min_duration[index] = best_duration

        best_finish = float("inf")
        for index in range(n - 1, -1, -1):
            start, duration = rides[index]
            best_finish = min(best_finish, start + duration)
            self.suffix_min_finish[index] = best_finish

    def earliest_finish_after(self, time: int) -> int:
        index = bisect_right(self.starts, time) - 1
        answer = float("inf")

        if index >= 0:
            answer = min(answer, time + self.prefix_min_duration[index])

        if index + 1 < len(self.starts):
            answer = min(answer, self.suffix_min_finish[index + 1])

        return answer


class Solution:
    def earliestFinishTime(
        self,
        landStartTime: List[int],
        landDuration: List[int],
        waterStartTime: List[int],
        waterDuration: List[int],
    ) -> int:
        """
        3635. Earliest Finish Time for Land and Water Rides II
        Time: O((n + m) log(n + m))
        Space: O(n + m)
        """
        land_options = RideOptions(landStartTime, landDuration)
        water_options = RideOptions(waterStartTime, waterDuration)

        answer = float("inf")

        for start, duration in zip(landStartTime, landDuration):
            answer = min(answer, water_options.earliest_finish_after(start + duration))

        for start, duration in zip(waterStartTime, waterDuration):
            answer = min(answer, land_options.earliest_finish_after(start + duration))

        return answer
