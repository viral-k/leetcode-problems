import java.util.Arrays;

/**
 * 3551. Minimum Swaps to Sort by Digit Sum
 * Time: O(n log n)
 * Space: O(n)
 */
class Solution {
    public int minSwaps(int[] nums) {
        int n = nums.length;

        // Pack (digit sum, value) and the index into one long so the sort runs
        // on a primitive array instead of boxing into Integer[] with a
        // comparator. Digit sum <= 81 and value <= 1e9, so the key fits in 37
        // bits; shifting by 17 leaves room for indices up to 131071.
        long[] keyed = new long[n];
        for (int i = 0; i < n; i++) {
            long key = digitSum(nums[i]) * 1_000_000_001L + nums[i];
            keyed[i] = (key << 17) | i;
        }
        Arrays.sort(keyed);

        // order[t] = original index of the element that belongs at position t.
        // Values are distinct, so the key never ties and this is a permutation.
        int[] order = new int[n];
        for (int t = 0; t < n; t++) {
            order[t] = (int) (keyed[t] & 0x1FFFF);
        }

        // a cycle of length k needs k - 1 swaps; fixed points cost nothing
        boolean[] visited = new boolean[n];
        int swaps = 0;
        for (int t = 0; t < n; t++) {
            if (visited[t]) {
                continue;
            }
            int length = 0;
            int j = t;
            while (!visited[j]) {
                visited[j] = true;
                j = order[j];
                length++;
            }
            swaps += length - 1;
        }

        return swaps;
    }

    private int digitSum(int x) {
        int total = 0;
        while (x > 0) {
            total += x % 10;
            x /= 10;
        }
        return total;
    }
}
