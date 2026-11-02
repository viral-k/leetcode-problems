import java.util.concurrent.ThreadLocalRandom;

/**
 * 462. Minimum Moves to Equal Array Elements II
 * Time: O(n) expected
 * Space: O(1)
 */
class Solution {
    public int minMoves2(int[] nums) {
        int median = select(nums, nums.length / 2);
        long moves = 0;
        for (int x : nums) {
            moves += Math.abs((long) x - median);
        }
        return (int) moves;
    }

    // Quickselect: returns the element of rank k (0-indexed) and reorders nums in place.
    // Random pivot, three-way partition so runs of equal values stay linear.
    private int select(int[] nums, int k) {
        ThreadLocalRandom rnd = ThreadLocalRandom.current();
        int lo = 0, hi = nums.length - 1;
        while (true) {
            int pivot = nums[lo + rnd.nextInt(hi - lo + 1)];
            // After the loop: [lo, lt) < pivot, [lt, gt] == pivot, (gt, hi] > pivot.
            int lt = lo, i = lo, gt = hi;
            while (i <= gt) {
                if (nums[i] < pivot) {
                    swap(nums, lt++, i++);
                } else if (nums[i] > pivot) {
                    swap(nums, i, gt--);
                } else {
                    i++;
                }
            }
            if (k < lt) {
                hi = lt - 1;
            } else if (k > gt) {
                lo = gt + 1;
            } else {
                return pivot;
            }
        }
    }

    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
