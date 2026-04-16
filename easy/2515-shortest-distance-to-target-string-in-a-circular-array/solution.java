import java.util.List;

/**
 * 2515. Shortest Distance to Target String in a Circular Array
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int closetTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDist = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                int clockwise = (i - startIndex + n) % n;
                int counterClockwise = n - clockwise;
                minDist = Math.min(minDist, Math.min(clockwise, counterClockwise));
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}
