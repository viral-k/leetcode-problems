/**
 * 1871. Jump Game VII
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        boolean[] reachable = new boolean[n];
        reachable[0] = true;
        int reachableCount = 0;

        for (int index = 1; index < n; index++) {
            int addIndex = index - minJump;
            if (addIndex >= 0 && reachable[addIndex]) {
                reachableCount++;
            }

            int removeIndex = index - maxJump - 1;
            if (removeIndex >= 0 && reachable[removeIndex]) {
                reachableCount--;
            }

            reachable[index] = s.charAt(index) == '0' && reachableCount > 0;
        }

        return reachable[n - 1];
    }
}
