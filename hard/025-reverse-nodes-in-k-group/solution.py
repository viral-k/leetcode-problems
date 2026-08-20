from typing import Optional


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def reverseKGroup(self, head: Optional["ListNode"], k: int) -> Optional["ListNode"]:
        """
        25. Reverse Nodes in k-Group
        Time: O(n)
        Space: O(1)
        """
        dummy = ListNode(0, head)
        group_prev = dummy

        while True:
            # Find the kth node from group_prev; stop if fewer than k remain.
            kth = group_prev
            for _ in range(k):
                kth = kth.next
                if kth is None:
                    return dummy.next

            group_next = kth.next

            # Reverse the group; seeding prev with group_next links the
            # new tail to the rest of the list automatically.
            prev, cur = group_next, group_prev.next
            while cur is not group_next:
                nxt = cur.next
                cur.next = prev
                prev = cur
                cur = nxt

            # The old head is now the group's tail.
            tmp = group_prev.next
            group_prev.next = kth
            group_prev = tmp
