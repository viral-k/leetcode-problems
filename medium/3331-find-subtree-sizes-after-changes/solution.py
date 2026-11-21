from typing import List


class Solution:
    def findSubtreeSizes(self, parent: List[int], s: str) -> List[int]:
        """
        3331. Find Subtree Sizes After Changes
        Time: O(n)
        Space: O(n)
        """
        n = len(parent)
        children = [[] for _ in range(n)]
        for x in range(1, n):
            children[parent[x]].append(x)

        ch = [ord(c) - 97 for c in s]
        new_parent = parent[:]
        last = [-1] * 26     # deepest node on the current path with each letter
        saved = [-1] * n     # last[ch[x]] before x was entered
        order = []           # original preorder
        stack = [0]
        while stack:
            x = stack.pop()
            if x >= 0:       # enter
                order.append(x)
                c = ch[x]
                if last[c] != -1:
                    new_parent[x] = last[c]
                saved[x] = last[c]
                last[c] = x
                stack.append(~x)
                stack.extend(children[x])
            else:            # exit
                x = ~x
                last[ch[x]] = saved[x]

        # New parents are original ancestors, so reversed preorder puts
        # every child before its new parent.
        size = [1] * n
        for x in reversed(order):
            if x:
                size[new_parent[x]] += size[x]
        return size
