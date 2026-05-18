import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * 1345. Jump Game IV
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) {
            return 0;
        }

        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int index = 0; index < n; index++) {
            valueToIndices.computeIfAbsent(arr[index], key -> new ArrayList<>()).add(index);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int count = 0; count < levelSize; count++) {
                int index = queue.poll();
                if (index == n - 1) {
                    return steps;
                }

                List<Integer> nextIndices = valueToIndices.get(arr[index]);
                nextIndices.add(index - 1);
                nextIndices.add(index + 1);

                for (int nextIndex : nextIndices) {
                    if (nextIndex >= 0 && nextIndex < n && !visited[nextIndex]) {
                        visited[nextIndex] = true;
                        queue.offer(nextIndex);
                    }
                }

                nextIndices.clear();
            }

            steps++;
        }

        return -1;
    }
}
