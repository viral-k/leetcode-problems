/**
 * 1784. Check if Binary String Has at Most One Segment of Ones
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean checkOnesSegment(String s) {
        return !s.contains("01");
    }
}
