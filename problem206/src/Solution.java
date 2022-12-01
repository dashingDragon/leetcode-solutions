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

    // recursive solution
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode next = head.next;
        ListNode new_head = reverseList(head.next);
        next.next = head;
        head.next = null;
        return new_head;
    }


    // iterative solution
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode l = head;
        ListNode h = head.next;
        ListNode tmp;
        l.next = null;
        while (h != null) {
            tmp = h.next;
            h.next = l;
            l = h;
            h = tmp;
        }
        return l;
    }

}