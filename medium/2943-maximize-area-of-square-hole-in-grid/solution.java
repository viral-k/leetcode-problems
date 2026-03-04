import java.util.Arrays;

/**
 * 2943. Maximize Area of Square Hole in Grid
 * Time: O(h log h + v log v)
 * Space: O(1)
 */
class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        int maxH = maxGap(hBars);
        int maxV = maxGap(vBars);
        
        int side = Math.min(maxH, maxV);
        return side * side;
    }
    
    private int maxGap(int[] arr) {
        Arrays.sort(arr);
        
        int longest = 1;
        int curr = 1;
        
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1] + 1) {
                curr++;
            } else {
                longest = Math.max(longest, curr);
                curr = 1;
            }
        }
        
        longest = Math.max(longest, curr);
        return longest + 1;
    }
}
