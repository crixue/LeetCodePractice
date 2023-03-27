package leetcode.list;

import leetcode.common.ListNode;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = head, slow = head, pre = dummy;
        for (int i = 0; i < n-1; i++) {
            fast = fast.next;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            pre = pre.next;
        }

        pre.next = slow.next;

        return dummy.next;
    }

}
