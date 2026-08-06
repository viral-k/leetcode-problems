/**
 * 3345. Smallest Divisible Digit Product I
 * Time: O(A * d)
 * Space: O(1)
 */
class Solution {
    public int smallestNumber(int n, int t) {
        int x = n;
        while (true) {
            int product = 1;
            for (int y = x; y > 0; y /= 10) {
                product *= y % 10;
            }
            if (product % t == 0) {
                return x;
            }
            x++;
        }
    }
}
