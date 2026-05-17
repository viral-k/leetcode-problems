import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 1306. Jump Game III
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public boolean canReach(int[] arr, int start) {
        int n = arr.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int index = queue.poll();

            if (arr[index] == 0) {
                return true;
            }

            int forward = index + arr[index];
            int backward = index - arr[index];

            if (forward < n && !visited[forward]) {
                visited[forward] = true;
                queue.offer(forward);
            }

            if (backward >= 0 && !visited[backward]) {
                visited[backward] = true;
                queue.offer(backward);
            }
        }

        return false;
    }
}
