/**
 * 1689. Partitioning Into Minimum Number Of Deci-Binary Numbers
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minPartitions(String n) {
        int max = 0;
        for (char c : n.toCharArray()) {
            max = Math.max(max, c - '0');
        }
        return max;
    }
}
