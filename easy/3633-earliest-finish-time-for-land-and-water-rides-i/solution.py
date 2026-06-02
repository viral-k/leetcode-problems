from typing import List


class Solution:
    def earliestFinishTime(
        self,
        landStartTime: List[int],
        landDuration: List[int],
        waterStartTime: List[int],
        waterDuration: List[int],
    ) -> int:
        """
        3633. Earliest Finish Time for Land and Water Rides I
        Time: O(n * m)
        Space: O(1)
        """
        answer = float("inf")

        for land_start, land_duration in zip(landStartTime, landDuration):
            for water_start, water_duration in zip(waterStartTime, waterDuration):
                land_first = max(land_start + land_duration, water_start) + water_duration
                water_first = max(water_start + water_duration, land_start) + land_duration
                answer = min(answer, land_first, water_first)

        return answer
