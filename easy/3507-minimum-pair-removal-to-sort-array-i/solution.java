import java.util.ArrayList;
import java.util.List;

/**
 * 3507. Minimum Pair Removal to Sort Array I
 * Time: O(n³)
 * Space: O(n)
 */
class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }

        int ops = 0;

        while (!isNonDecreasing(list)) {
            int minSum = Integer.MAX_VALUE;
            int idx = 0;

            for (int i = 0; i < list.size() - 1; i++) {
                int sum = list.get(i) + list.get(i + 1);
                if (sum < minSum) {
                    minSum = sum;
                    idx = i;
                }
            }

            list.set(idx, list.get(idx) + list.get(idx + 1));
            list.remove(idx + 1);
            ops++;
        }

        return ops;
    }

    private boolean isNonDecreasing(List<Integer> arr) {
        for (int i = 1; i < arr.size(); i++) {
            if (arr.get(i) < arr.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}
