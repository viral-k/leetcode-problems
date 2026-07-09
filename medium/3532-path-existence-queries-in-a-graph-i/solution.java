/**
 * 3532. Path Existence Queries in a Graph I
 * Time: O(n + q)
 * Space: O(n)
 */
class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        // Component id: increments whenever a consecutive gap exceeds maxDiff.
        int[] comp = new int[n];
        for (int i = 1; i < n; i++) {
            comp[i] = comp[i - 1] + (nums[i] - nums[i - 1] > maxDiff ? 1 : 0);
        }

        boolean[] ans = new boolean[queries.length];
        for (int i = 0; i < queries.length; i++) {
            ans[i] = comp[queries[i][0]] == comp[queries[i][1]];
        }
        return ans;
    }
}
