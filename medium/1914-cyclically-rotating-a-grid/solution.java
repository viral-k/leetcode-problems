import java.util.*;

/**
 * 1914. Cyclically Rotating a Grid
 * Time: O(m × n)
 * Space: O(m + n)
 */
class Solution {
    public int[][] rotateGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int layers = Math.min(m, n) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<int[]> coords = layerCoordinates(m, n, layer);
            int size = coords.size();
            int[] values = new int[size];

            for (int i = 0; i < size; i++) {
                int[] cell = coords.get(i);
                values[i] = grid[cell[0]][cell[1]];
            }

            int shift = k % size;

            for (int i = 0; i < size; i++) {
                int[] cell = coords.get(i);
                grid[cell[0]][cell[1]] = values[(i - shift + size) % size];
            }
        }

        return grid;
    }

    private List<int[]> layerCoordinates(int m, int n, int layer) {
        int top = layer;
        int bottom = m - 1 - layer;
        int left = layer;
        int right = n - 1 - layer;
        List<int[]> coords = new ArrayList<>();

        for (int row = top; row <= bottom; row++) {
            coords.add(new int[]{row, left});
        }

        for (int col = left + 1; col <= right; col++) {
            coords.add(new int[]{bottom, col});
        }

        for (int row = bottom - 1; row >= top; row--) {
            coords.add(new int[]{row, right});
        }

        for (int col = right - 1; col > left; col--) {
            coords.add(new int[]{top, col});
        }

        return coords;
    }
}
