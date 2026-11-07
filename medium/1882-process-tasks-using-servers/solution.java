import java.util.*;

/**
 * 1882. Process Tasks Using Servers
 * Time: O((n + m) log n)
 * Space: O(n + m)
 */
class Solution {
    // Keys pack (major, index) into one long: indices are below 2^18.
    private static final int SHIFT = 18;
    private static final long MASK = (1L << SHIFT) - 1;

    public int[] assignTasks(int[] servers, int[] tasks) {
        int n = servers.length, m = tasks.length;

        PriorityQueue<Long> free = new PriorityQueue<>(n); // (weight, index)
        for (int i = 0; i < n; i++) {
            free.add(((long) servers[i] << SHIFT) | i);
        }
        PriorityQueue<Long> busy = new PriorityQueue<>(n); // (free time, index)

        int[] ans = new int[m];
        long t = 0;
        for (int j = 0; j < m; j++) {
            // Task j starts no earlier than it arrives or than task j - 1 started.
            t = Math.max(t, j);
            if (free.isEmpty()) {
                t = Math.max(t, busy.peek() >> SHIFT);
            }
            while (!busy.isEmpty() && (busy.peek() >> SHIFT) <= t) {
                int i = (int) (busy.poll() & MASK);
                free.add(((long) servers[i] << SHIFT) | i);
            }

            int i = (int) (free.poll() & MASK);
            ans[j] = i;
            busy.add(((t + tasks[j]) << SHIFT) | i);
        }
        return ans;
    }
}
