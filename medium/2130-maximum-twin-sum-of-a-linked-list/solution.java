/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

/**
 * 2130. Maximum Twin Sum of a Linked List
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public int pairSum(ListNode head) {
        // Find the middle (start of the second half).
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half.
        ListNode prev = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        // Pair the first half with the reversed second half.
        int best = 0;
        ListNode first = head;
        ListNode second = prev;
        while (second != null) {
            best = Math.max(best, first.val + second.val);
            first = first.next;
            second = second.next;
        }

        return best;
    }
}
