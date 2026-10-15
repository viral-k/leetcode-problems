/**
 * 2913. Subarrays Distinct Element Sum of Squares I
 * Time: O(n^2)
 * Space: O(V) where V = 100 is the value range
 */
class Solution {
    public int sumCounts(int[] nums) {
        int n = nums.length;
        int total = 0;
        boolean[] seen = new boolean[101];  // nums[i] <= 100, direct lookup

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(seen, false);
            int distinct = 0;
            for (int j = i; j < n; j++) {
                int v = nums[j];
                if (!seen[v]) {
                    seen[v] = true;
                    distinct++;
                }
                total += distinct * distinct;
            }
        }

        return total;
    }
}
