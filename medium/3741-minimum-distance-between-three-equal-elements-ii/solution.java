import java.util.*;

/**
 * 3741. Minimum Distance Between Three Equal Elements II
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int minimumDistance(int[] nums) {
        Map<Integer, List<Integer>> indices = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        for (List<Integer> idxList : indices.values()) {
            if (idxList.size() >= 3) {
                for (int i = 0; i < idxList.size() - 2; i++) {
                    int span = idxList.get(i + 2) - idxList.get(i);
                    minDist = Math.min(minDist, 2 * span);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
