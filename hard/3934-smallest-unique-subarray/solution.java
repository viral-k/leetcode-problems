import java.util.*;

/**
 * 3934. Smallest Unique Subarray
 * Time: O(n) expected
 * Space: O(n)
 */
class Solution {
    public int smallestUniqueSubarray(int[] nums) {
        // Suffix automaton with hash map transitions, at most 2n states.
        int n = nums.length;
        List<Map<Integer, Integer>> next = new ArrayList<>();
        int[] link = new int[2 * n + 1];
        int[] len = new int[2 * n + 1];
        next.add(new HashMap<>());
        link[0] = -1;
        int last = 0;
        for (int x : nums) {
            int cur = next.size();
            next.add(new HashMap<>(2));
            len[cur] = len[last] + 1;
            int p = last;
            while (p != -1 && !next.get(p).containsKey(x)) {
                next.get(p).put(x, cur);
                p = link[p];
            }
            if (p != -1) {
                int q = next.get(p).get(x);
                if (len[q] == len[p] + 1) {
                    link[cur] = q;
                } else {
                    int clone = next.size();
                    next.add(new HashMap<>(next.get(q)));
                    link[clone] = link[q];
                    len[clone] = len[p] + 1;
                    while (p != -1 && next.get(p).getOrDefault(x, -1) == q) {
                        next.get(p).put(x, clone);
                        p = link[p];
                    }
                    link[q] = clone;
                    link[cur] = clone;
                }
            }
            last = cur;
        }

        // A state that nothing links to occurs exactly once, and its shortest
        // subarray is one longer than the longest in its suffix link.
        int states = next.size();
        boolean[] hasChild = new boolean[states];
        for (int v = 1; v < states; v++) {
            hasChild[link[v]] = true;
        }
        int best = n;
        for (int v = 1; v < states; v++) {
            if (!hasChild[v]) {
                best = Math.min(best, len[link[v]] + 1);
            }
        }
        return best;
    }
}
