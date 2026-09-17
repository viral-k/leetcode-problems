/**
 * 1477. Find Two Non-overlapping Sub-arrays Each With Target Sum
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        final int INF = Integer.MAX_VALUE;
        // best[i] = shortest target-sum subarray ending at index <= i
        int[] best = new int[n];
        int curBest = INF;
        int answer = INF;

        int left = 0;
        long window = 0;
        for (int right = 0; right < n; right++) {
            window += arr[right];
            // all values positive, so shrinking from the left is monotone
            while (window > target) {
                window -= arr[left];
                left++;
            }

            if (window == target) {
                int length = right - left + 1;
                if (left > 0 && best[left - 1] != INF) {
                    answer = Math.min(answer, length + best[left - 1]);
                }
                curBest = Math.min(curBest, length);
            }

            best[right] = curBest;
        }

        return answer == INF ? -1 : answer;
    }
}
