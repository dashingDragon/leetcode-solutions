class Solution {
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list2;
        ListNode new_head = list1.val < list2.val ? list1 : list2;
        ListNode changeNext = null;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                changeNext = list1;
                list1 = list1.next;
                if (list1 == null) break;
                changeNext.next = list1.val < list2.val ? list1 : list2;
            } else {
                changeNext = list2;
                list2 = list2.next;
                if (list2 == null) break;
                changeNext.next = list1.val < list2.val ? list1 : list2;
            }
        }
        changeNext.next = list1 == null ? list2 : list1;
        return new_head;
    }
}