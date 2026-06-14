from typing import Optional


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next


class Solution:
    def pairSum(self, head: Optional["ListNode"]) -> int:
        """
        2130. Maximum Twin Sum of a Linked List
        Time: O(n)
        Space: O(1)
        """
        # Find the middle (start of the second half).
        slow, fast = head, head
        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

        # Reverse the second half.
        prev = None
        while slow:
            nxt = slow.next
            slow.next = prev
            prev = slow
            slow = nxt

        # Pair the first half with the reversed second half.
        best = 0
        first, second = head, prev
        while second:
            best = max(best, first.val + second.val)
            first = first.next
            second = second.next

        return best
