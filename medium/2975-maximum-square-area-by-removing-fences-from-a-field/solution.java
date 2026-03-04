import java.util.Arrays;
import java.util.HashSet;

/**
 * 2975. Maximum Square Area by Removing Fences From a Field
 * Time: O(h² + v²)
 * Space: O(h²)
 */
class Solution {
    public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
        final long MOD = 1_000_000_007L;
        
        int[] h = new int[hFences.length + 2];
        int[] v = new int[vFences.length + 2];
        
        h[0] = 1;
        h[h.length - 1] = m;
        for (int i = 0; i < hFences.length; i++) {
            h[i + 1] = hFences[i];
        }
        
        v[0] = 1;
        v[v.length - 1] = n;
        for (int i = 0; i < vFences.length; i++) {
            v[i + 1] = vFences[i];
        }
        
        Arrays.sort(h);
        Arrays.sort(v);
        
        HashSet<Integer> hDist = new HashSet<>();
        for (int i = 0; i < h.length; i++) {
            for (int j = i + 1; j < h.length; j++) {
                hDist.add(h[j] - h[i]);
            }
        }
        
        int maxSide = -1;
        for (int i = 0; i < v.length; i++) {
            for (int j = i + 1; j < v.length; j++) {
                int d = v[j] - v[i];
                if (hDist.contains(d)) {
                    maxSide = Math.max(maxSide, d);
                }
            }
        }
        
        if (maxSide == -1) {
            return -1;
        }
        
        long area = (1L * maxSide * maxSide) % MOD;
        return (int) area;
    }
}
