from typing import Optional


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def deleteMiddle(self, head: Optional["ListNode"]) -> Optional["ListNode"]:
        """
        2095. Delete the Middle Node of a Linked List
        Time: O(n)
        Space: O(1)
        """
        if head is None or head.next is None:
            return None

        prev = None
        slow, fast = head, head

        while fast and fast.next:
            prev = slow
            slow = slow.next
            fast = fast.next.next

        # slow is the middle node; splice it out.
        prev.next = slow.next
        return head
