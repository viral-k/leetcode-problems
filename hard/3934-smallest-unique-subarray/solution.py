from typing import List


class Solution:
    def smallestUniqueSubarray(self, nums: List[int]) -> int:
        """
        3934. Smallest Unique Subarray
        Time: O(n) expected
        Space: O(n)
        """
        # Suffix automaton with hash map transitions.
        nxt = [{}]
        link = [-1]
        length = [0]
        last = 0
        for x in nums:
            cur = len(nxt)
            nxt.append({})
            link.append(0)
            length.append(length[last] + 1)
            p = last
            while p != -1 and x not in nxt[p]:
                nxt[p][x] = cur
                p = link[p]
            if p != -1:
                q = nxt[p][x]
                if length[q] == length[p] + 1:
                    link[cur] = q
                else:
                    clone = len(nxt)
                    nxt.append(nxt[q].copy())
                    link.append(link[q])
                    length.append(length[p] + 1)
                    while p != -1 and nxt[p].get(x) == q:
                        nxt[p][x] = clone
                        p = link[p]
                    link[q] = link[cur] = clone
            last = cur

        # A state that nothing links to occurs exactly once, and its shortest
        # subarray is one longer than the longest in its suffix link.
        has_child = [False] * len(nxt)
        for v in range(1, len(nxt)):
            has_child[link[v]] = True
        return min(length[link[v]] + 1
                   for v in range(1, len(nxt)) if not has_child[v])
