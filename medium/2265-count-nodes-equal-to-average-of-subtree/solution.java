/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 2265. Count Nodes Equal to Average of Subtree
 * Time: O(n)
 * Space: O(h)
 */
class Solution {
    private int answer = 0;

    public int averageOfSubtree(TreeNode root) {
        dfs(root);
        return answer;
    }

    /** Returns {sum of subtree values, number of nodes}. */
    private int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        int total = left[0] + right[0] + node.val;
        int count = left[1] + right[1] + 1;

        // values are non-negative, so integer division is the required floor
        if (node.val == total / count) {
            answer++;
        }

        return new int[]{total, count};
    }
}
