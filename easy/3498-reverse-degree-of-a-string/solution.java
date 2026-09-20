/**
 * 3498. Reverse Degree of a String
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int reverseDegree(String s) {
        int total = 0;
        for (int i = 0; i < s.length(); i++) {
            int weight = 26 - (s.charAt(i) - 'a');
            total += weight * (i + 1);
        }
        return total;
    }
}
