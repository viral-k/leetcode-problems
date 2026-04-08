/**
 * 3653. XOR After Range Multiplication Queries I
 * Time: O(q × n)
 * Space: O(1)
 */
class Solution {
    public int xorAfterMultiplication(int[] nums, int[][] queries) {
        long MOD = 1_000_000_007L;

        for (int[] q : queries) {
            int l = q[0], r = q[1], k = q[2], v = q[3];

            int idx = l;
            while (idx <= r) {
                nums[idx] = (int) ((nums[idx] * (long) v) % MOD);
                idx += k;
            }
        }

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
