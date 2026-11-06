import java.util.*;

/**
 * 2747. Count Zero Request Servers
 * Time: O(m log m + q log q + n)
 * Space: O(n + m + q)
 */
class Solution {
    private static final int BITS = 17; // ids and indices are at most 10^5 < 2^17
    private static final long MASK = (1L << BITS) - 1;

    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = logs.length, k = queries.length;

        // Pack (time, server) and (query, index) into longs so both sort
        // without boxing or changing the input.
        long[] byTime = new long[m];
        for (int i = 0; i < m; i++) {
            byTime[i] = ((long) logs[i][1] << BITS) | logs[i][0];
        }
        Arrays.sort(byTime);
        long[] byQuery = new long[k];
        for (int i = 0; i < k; i++) {
            byQuery[i] = ((long) queries[i] << BITS) | i;
        }
        Arrays.sort(byQuery);

        int[] count = new int[n + 1]; // server ids are 1-based
        int active = 0, left = 0, right = 0;
        int[] answer = new int[k];

        // Answer queries in increasing order so the window only moves right.
        for (long packed : byQuery) {
            long q = packed >> BITS;
            int index = (int) (packed & MASK);
            while (right < m && (byTime[right] >> BITS) <= q) {
                int server = (int) (byTime[right] & MASK);
                if (count[server]++ == 0) {
                    active++;
                }
                right++;
            }
            while (left < right && (byTime[left] >> BITS) < q - x) {
                int server = (int) (byTime[left] & MASK);
                if (--count[server] == 0) {
                    active--;
                }
                left++;
            }
            answer[index] = n - active;
        }
        return answer;
    }
}
