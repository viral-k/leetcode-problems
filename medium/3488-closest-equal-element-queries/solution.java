import java.util.*;

/**
 * 3488. Closest Equal Element Queries
 * Time: O(n + q)
 * Space: O(n)
 */
class Solution {
    public List<Integer> solveQueries(int[] nums, int[] queries) {
        int n = nums.length;

        // Group indices by value
        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        // Precompute minimum distance for each index
        int[] minDist = new int[n];
        Arrays.fill(minDist, -1);

        for (List<Integer> idxList : indices.values()) {
            if (idxList.size() < 2) continue;

            int m = idxList.size();
            for (int k = 0; k < m; k++) {
                int i = idxList.get(k);
                int prevIdx = idxList.get((k - 1 + m) % m);
                int nextIdx = idxList.get((k + 1) % m);

                // Circular distance to previous
                int distPrev = (i - prevIdx + n) % n;
                distPrev = Math.min(distPrev, n - distPrev);

                // Circular distance to next
                int distNext = (nextIdx - i + n) % n;
                distNext = Math.min(distNext, n - distNext);

                minDist[i] = Math.min(distPrev, distNext);
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int q : queries) {
            result.add(minDist[q]);
        }
        return result;
    }
}
