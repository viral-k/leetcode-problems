from typing import List, Optional


# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def createBinaryTree(self, descriptions: List[List[int]]) -> Optional["TreeNode"]:
        """
        2196. Create Binary Tree From Descriptions
        Time: O(n)
        Space: O(n)
        """
        nodes = {}
        children = set()

        def get_node(value: int) -> "TreeNode":
            if value not in nodes:
                nodes[value] = TreeNode(value)
            return nodes[value]

        for parent, child, is_left in descriptions:
            parent_node = get_node(parent)
            child_node = get_node(child)

            if is_left == 1:
                parent_node.left = child_node
            else:
                parent_node.right = child_node

            children.add(child)

        for value, node in nodes.items():
            if value not in children:
                return node

        return None
