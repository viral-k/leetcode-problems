/**
 * 2161. Partition Array According to Given Pivot
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] result = new int[n];

        int left = 0;
        int right = n - 1;

        // Fill less-than values from the front, greater-than values from the back.
        // Reverse the back fill afterwards to restore relative order.
        for (int i = 0; i < n; i++) {
            if (nums[i] < pivot) {
                result[left++] = nums[i];
            }
            if (nums[n - 1 - i] > pivot) {
                result[right--] = nums[n - 1 - i];
            }
        }

        // Remaining middle slots are the pivot values.
        while (left <= right) {
            result[left++] = pivot;
        }

        return result;
    }
}
