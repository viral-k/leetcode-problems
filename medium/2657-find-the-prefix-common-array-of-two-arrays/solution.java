/**
 * 2657. Find the Prefix Common Array of Two Arrays
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] seen = new int[n + 1];
        int[] answer = new int[n];
        int common = 0;

        for (int i = 0; i < n; i++) {
            seen[A[i]]++;
            if (seen[A[i]] == 2) {
                common++;
            }

            seen[B[i]]++;
            if (seen[B[i]] == 2) {
                common++;
            }

            answer[i] = common;
        }

        return answer;
    }
}
