/**
 * 1340. Jump Game V
 * Time: O(n * d)
 * Space: O(n)
 */
class Solution {
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        int[] memo = new int[n];
        int answer = 1;

        for (int index = 0; index < n; index++) {
            answer = Math.max(answer, dfs(index, arr, d, memo));
        }

        return answer;
    }

    private int dfs(int index, int[] arr, int d, int[] memo) {
        if (memo[index] != 0) {
            return memo[index];
        }

        int n = arr.length;
        int best = 1;

        for (int nextIndex = index + 1; nextIndex < n && nextIndex <= index + d; nextIndex++) {
            if (arr[nextIndex] >= arr[index]) {
                break;
            }
            best = Math.max(best, 1 + dfs(nextIndex, arr, d, memo));
        }

        for (int nextIndex = index - 1; nextIndex >= 0 && nextIndex >= index - d; nextIndex--) {
            if (arr[nextIndex] >= arr[index]) {
                break;
            }
            best = Math.max(best, 1 + dfs(nextIndex, arr, d, memo));
        }

        memo[index] = best;
        return best;
    }
}
