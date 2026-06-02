/**
 * 3633. Earliest Finish Time for Land and Water Rides I
 * Time: O(n * m)
 * Space: O(1)
 */
class Solution {
    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {
        int answer = Integer.MAX_VALUE;

        for (int land = 0; land < landStartTime.length; land++) {
            for (int water = 0; water < waterStartTime.length; water++) {
                int landFirst = Math.max(
                    landStartTime[land] + landDuration[land],
                    waterStartTime[water]
                ) + waterDuration[water];

                int waterFirst = Math.max(
                    waterStartTime[water] + waterDuration[water],
                    landStartTime[land]
                ) + landDuration[land];

                answer = Math.min(answer, Math.min(landFirst, waterFirst));
            }
        }

        return answer;
    }
}
