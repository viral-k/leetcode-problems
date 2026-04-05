/**
 * 657. Robot Return to Origin
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean judgeCircle(String moves) {
        int x = 0, y = 0;

        for (char m : moves.toCharArray()) {
            if (m == 'U') y++;
            else if (m == 'D') y--;
            else if (m == 'R') x++;
            else x--;
        }

        return x == 0 && y == 0;
    }
}
