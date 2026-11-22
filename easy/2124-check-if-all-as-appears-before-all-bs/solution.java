/**
 * 2124. Check if All A's Appears Before All B's
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean checkString(String s) {
        // Valid strings look like a...ab...b; any violation contains "ba".
        return !s.contains("ba");
    }
}
