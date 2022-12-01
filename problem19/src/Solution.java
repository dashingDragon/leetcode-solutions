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
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int diff = 0;

        while (diff <= n) {
            if (curr == null) {
                return head.next;
            }
            curr = curr.next;
            diff++;
        }
        ListNode prev = head;
        while (curr != null) {
            curr = curr.next;
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
    }
}