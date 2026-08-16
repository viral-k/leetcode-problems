/**
 * 2029. Stone Game IX
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean stoneGameIX(int[] stones) {
        int[] count = new int[3];
        for (int s : stones) {
            count[s % 3]++;
        }
        int c0 = count[0], c1 = count[1], c2 = count[2];

        if (c0 % 2 == 0) {
            // zeros cancel in turn order: Alice needs both residues to start a chain
            return c1 >= 1 && c2 >= 1;
        }
        // one leftover pass flips the race; need a gap of at least 3
        return Math.abs(c1 - c2) > 2;
    }
}
