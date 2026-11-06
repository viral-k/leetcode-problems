/**
 * 239. Sliding Window Maximum
 * Time: O(n)
 * Space: O(k)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        // Circular deque of indices whose values strictly decrease from front
        // to back. It holds at most k + 1 indices. The front is the current maximum.
        int cap = k + 1;
        int[] dq = new int[cap];
        int head = 0, size = 0;
        int[] out = new int[n - k + 1];
        for (int i = 0; i < n; i++) {
            if (size > 0 && dq[head] == i - k) {
                head = (head + 1) % cap;
                size--;
            }
            // An older value <= nums[i] can never be a maximum again.
            while (size > 0 && nums[dq[(head + size - 1) % cap]] <= nums[i]) {
                size--;
            }
            dq[(head + size) % cap] = i;
            size++;
            if (i >= k - 1) {
                out[i - k + 1] = nums[dq[head]];
            }
        }
        return out;
    }
}
