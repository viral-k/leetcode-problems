/**
 * 3886. Sum of Sortable Integers
 * Time: O(n + sigma(n))
 * Space: O(n)
 */
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        // sufMin[m] = min(nums[m..n-1]), so sufMin[n] acts as +infinity
        int[] sufMin = new int[n + 1];
        sufMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sufMin[i] = Math.min(nums[i], sufMin[i + 1]);
        }

        // breakpoint[m]: the first m elements are the m smallest, which holds
        // exactly when max(nums[0..m-1]) <= min(nums[m..n-1])
        boolean[] breakpoint = new boolean[n + 1];
        int runMax = 0;
        for (int m = 1; m <= n; m++) {
            runMax = Math.max(runMax, nums[m - 1]);
            breakpoint[m] = runMax <= sufMin[m];
        }

        // desc[i] = number of j in 1..i with nums[j-1] > nums[j], so the
        // descents strictly inside [l, r) are desc[r-1] - desc[l]
        int[] desc = new int[n];
        for (int i = 1; i < n; i++) {
            desc[i] = desc[i - 1] + (nums[i - 1] > nums[i] ? 1 : 0);
        }

        int total = 0;
        for (int d = 1; (long) d * d <= n; d++) {
            if (n % d != 0) {
                continue;
            }
            if (sortable(nums, breakpoint, desc, d)) {
                total += d;
            }
            int other = n / d;
            if (other != d && sortable(nums, breakpoint, desc, other)) {
                total += other;
            }
        }

        return total;
    }

    private boolean sortable(int[] nums, boolean[] breakpoint, int[] desc, int k) {
        int n = nums.length;
        for (int l = 0; l < n; l += k) {
            int r = l + k;
            if (!breakpoint[r]) {
                return false;
            }
            // a block is rotatable into sorted order iff it has at most one
            // cyclic descent
            int cyclic = desc[r - 1] - desc[l] + (nums[r - 1] > nums[l] ? 1 : 0);
            if (cyclic > 1) {
                return false;
            }
        }
        return true;
    }
}
