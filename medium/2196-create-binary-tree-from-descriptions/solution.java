import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

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
 * 2196. Create Binary Tree From Descriptions
 * Time: O(n)
 * Space: O(n)
 */
class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodes = new HashMap<>();
        Set<Integer> children = new HashSet<>();

        for (int[] description : descriptions) {
            int parent = description[0];
            int child = description[1];
            int isLeft = description[2];

            TreeNode parentNode = nodes.computeIfAbsent(parent, TreeNode::new);
            TreeNode childNode = nodes.computeIfAbsent(child, TreeNode::new);

            if (isLeft == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }

            children.add(child);
        }

        for (Map.Entry<Integer, TreeNode> entry : nodes.entrySet()) {
            if (!children.contains(entry.getKey())) {
                return entry.getValue();
            }
        }

        return null;
    }
}
