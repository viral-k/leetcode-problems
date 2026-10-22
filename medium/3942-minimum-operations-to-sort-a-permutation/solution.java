/**
 * 3942. Minimum Operations to Sort a Permutation
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;

        int p = 0;
        while (nums[p] != 0) {
            p++;
        }

        int best = -1;

        // nums is Rot^p of the sorted array: reading forward from 0 gives
        // 0, 1, ..., n-1. Either L^p, or reverse-rotate-reverse for a cheap
        // rotate-right when p is close to n.
        boolean forward = true;
        for (int i = 0; i < n; i++) {
            if (nums[(p + i) % n] != i) {
                forward = false;
                break;
            }
        }
        if (forward) {
            best = Math.min(p, n - p + 2);
        }

        // nums is a rotation of the reversed sorted array: reading backward
        // from 0 gives 0, 1, ..., n-1. Either R then L^k, or L^(n-k) then R.
        boolean backward = true;
        for (int i = 0; i < n; i++) {
            if (nums[((p - i) % n + n) % n] != i) {
                backward = false;
                break;
            }
        }
        if (backward) {
            int k = n - 1 - p;
            int cost = Math.min(k + 1, n - k + 1);
            best = best < 0 ? cost : Math.min(best, cost);
        }

        return best;
    }
}
