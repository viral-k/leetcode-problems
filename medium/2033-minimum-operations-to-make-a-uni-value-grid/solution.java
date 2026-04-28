import java.util.*;

/**
 * 2033. Minimum Operations to Make a Uni-Value Grid
 * Time: O(mn * log(mn))
 * Space: O(mn)
 */
class Solution {
    public int minOperations(int[][] grid, int x) {
        int m = grid.length, n = grid[0].length;
        int[] arr = new int[m * n];

        // Flatten grid
        int idx = 0;
        int remainder = grid[0][0] % x;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] % x != remainder) {
                    return -1;
                }
                arr[idx++] = grid[i][j];
            }
        }

        // Sort and find median
        Arrays.sort(arr);
        int median = arr[arr.length / 2];

        // Count total operations
        int operations = 0;
        for (int val : arr) {
            operations += Math.abs(val - median) / x;
        }

        return operations;
    }
}
