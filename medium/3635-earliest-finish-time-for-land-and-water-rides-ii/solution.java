import java.util.Arrays;

/**
 * 3635. Earliest Finish Time for Land and Water Rides II
 * Time: O((n + m) log(n + m))
 * Space: O(n + m)
 */
class Solution {
    public int earliestFinishTime(
        int[] landStartTime,
        int[] landDuration,
        int[] waterStartTime,
        int[] waterDuration
    ) {
        RideOptions landOptions = new RideOptions(landStartTime, landDuration);
        RideOptions waterOptions = new RideOptions(waterStartTime, waterDuration);

        int answer = Integer.MAX_VALUE;

        for (int index = 0; index < landStartTime.length; index++) {
            int finishTime = landStartTime[index] + landDuration[index];
            answer = Math.min(answer, waterOptions.earliestFinishAfter(finishTime));
        }

        for (int index = 0; index < waterStartTime.length; index++) {
            int finishTime = waterStartTime[index] + waterDuration[index];
            answer = Math.min(answer, landOptions.earliestFinishAfter(finishTime));
        }

        return answer;
    }

    private static class RideOptions {
        private final int[] starts;
        private final int[] prefixMinDuration;
        private final int[] suffixMinFinish;

        RideOptions(int[] startTimes, int[] durations) {
            int n = startTimes.length;
            int[][] rides = new int[n][2];

            for (int index = 0; index < n; index++) {
                rides[index][0] = startTimes[index];
                rides[index][1] = durations[index];
            }

            Arrays.sort(rides, (a, b) -> a[0] - b[0]);

            starts = new int[n];
            prefixMinDuration = new int[n];
            suffixMinFinish = new int[n];

            int bestDuration = Integer.MAX_VALUE;
            for (int index = 0; index < n; index++) {
                starts[index] = rides[index][0];
                bestDuration = Math.min(bestDuration, rides[index][1]);
                prefixMinDuration[index] = bestDuration;
            }

            int bestFinish = Integer.MAX_VALUE;
            for (int index = n - 1; index >= 0; index--) {
                bestFinish = Math.min(bestFinish, rides[index][0] + rides[index][1]);
                suffixMinFinish[index] = bestFinish;
            }
        }

        int earliestFinishAfter(int time) {
            int index = upperBound(starts, time) - 1;
            int answer = Integer.MAX_VALUE;

            if (index >= 0) {
                answer = Math.min(answer, time + prefixMinDuration[index]);
            }

            if (index + 1 < starts.length) {
                answer = Math.min(answer, suffixMinFinish[index + 1]);
            }

            return answer;
        }

        private int upperBound(int[] values, int target) {
            int left = 0;
            int right = values.length;

            while (left < right) {
                int mid = left + (right - left) / 2;
                if (values[mid] <= target) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            return left;
        }
    }
}
