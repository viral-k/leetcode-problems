/**
 * 3644. Maximum K to Sort a Permutation
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int sortPermutation(int[] nums) {
        // k has to be a submask of every misplaced value, since each of them
        // must take part in a swap. The largest such k is their AND, and that
        // value is always reachable: the element k itself satisfies
        // k AND v == k for every misplaced v, so it can carry them all home.
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                k &= nums[i];
            }
        }

        return k == -1 ? 0 : k;
    }
}
