import java.util.*;

/**
 * 1606. Find Servers That Handled Most Number of Requests
 * Time: O(n log k)
 * Space: O(k)
 */
class Solution {
    private static final int SHIFT = 17; // server ids are below 10^5 < 2^17
    private static final long MASK = (1L << SHIFT) - 1;

    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        // A free server id is stored as the first request number >= i that maps
        // to it: i + (id - i) mod k. Every key stays in [i, i + k), so the
        // minimum is the first free server clockwise from i % k.
        PriorityQueue<Integer> free = new PriorityQueue<>(k);
        for (int s = 0; s < k; s++) {
            free.add(s);
        }
        PriorityQueue<Long> busy = new PriorityQueue<>(k); // (end time, server)
        int[] count = new int[k];

        for (int i = 0; i < arrival.length; i++) {
            long a = arrival[i];
            while (!busy.isEmpty() && (busy.peek() >> SHIFT) <= a) {
                int server = (int) (busy.poll() & MASK);
                free.add(i + Math.floorMod(server - i, k));
            }
            if (free.isEmpty()) {
                continue; // every server is busy: drop the request
            }
            int server = free.poll() % k;
            count[server]++;
            busy.add(((a + load[i]) << SHIFT) | server);
        }

        int best = 0;
        for (int c : count) {
            best = Math.max(best, c);
        }
        List<Integer> ans = new ArrayList<>();
        for (int s = 0; s < k; s++) {
            if (count[s] == best) {
                ans.add(s);
            }
        }
        return ans;
    }
}
