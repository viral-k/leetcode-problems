/**
 * 3727. Maximum Alternating Sum of Squares
 * Time: O(n + V) where V = 4 * 10^4
 * Space: O(V)
 */
class Solution {
    public long maxAlternatingSum(int[] nums) {
        final int LIMIT = 40000;  // |nums[i]| <= 4 * 10^4
        int n = nums.length;
        int add = (n + 1) / 2;    // positions 0, 2, 4, ... contribute positively

        // only the magnitude matters, since every term is squared
        int[] cnt = new int[LIMIT + 1];
        for (int v : nums) {
            cnt[Math.abs(v)]++;
        }

        // sweep high to low so the added side gets the largest squares
        long total = 0;
        for (int a = LIMIT; a >= 0; a--) {
            int c = cnt[a];
            if (c == 0) {
                continue;
            }
            long square = (long) a * a;
            int take = Math.min(c, add);
            total += take * square;
            add -= take;
            total -= (long) (c - take) * square;
        }

        return total;
    }
}
