from typing import Optional, Tuple


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def averageOfSubtree(self, root: Optional["TreeNode"]) -> int:
        """
        2265. Count Nodes Equal to Average of Subtree
        Time: O(n)
        Space: O(h)
        """
        self.answer = 0

        def dfs(node: Optional["TreeNode"]) -> Tuple[int, int]:
            # returns (sum of subtree values, number of nodes)
            if node is None:
                return 0, 0

            left_sum, left_count = dfs(node.left)
            right_sum, right_count = dfs(node.right)

            total = left_sum + right_sum + node.val
            count = left_count + right_count + 1

            # values are non-negative, so // is the required floor
            if node.val == total // count:
                self.answer += 1

            return total, count

        dfs(root)
        return self.answer
