import java.util.*;

/**
 * 1385. Find the Distance Value Between Two Arrays
 * Time: O((n + m) log m)
 * Space: O(1)
 */
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int m = arr2.length, count = 0;
        for (int x : arr1) {
            // First index with arr2[i] >= x - d.
            int lo = 0, hi = m;
            while (lo < hi) {
                int mid = (lo + hi) >>> 1;
                if (arr2[mid] < x - d) {
                    lo = mid + 1;
                } else {
                    hi = mid;
                }
            }
            // x counts when no arr2 value lies in [x - d, x + d].
            if (lo == m || arr2[lo] > x + d) {
                count++;
            }
        }
        return count;
    }
}
