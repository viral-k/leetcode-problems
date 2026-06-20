/**
 * 1732. Find the Highest Altitude
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int largestAltitude(int[] gain) {
        int altitude = 0;
        int highest = 0;

        for (int g : gain) {
            altitude += g;
            highest = Math.max(highest, altitude);
        }

        return highest;
    }
}
