/**
 * 3718. Smallest Missing Multiple of K
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int smallestMissingMultiple(int[] nums, int k) {
        boolean[] present = new boolean[101]; // values are in [1, 100]
        for (int x : nums) {
            present[x] = true;
        }

        int m = k;
        // a multiple above 100 can never appear in nums, so bounds-check first
        while (m <= 100 && present[m]) {
            m += k;
        }
        return m;
    }
}
