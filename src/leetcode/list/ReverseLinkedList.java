package leetcode.list;

import leetcode.common.ListNode;

public class ReverseLinkedList {

    private ListNode reverse(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode cur = null, nxt = head;
        while (nxt != null) {
            ListNode temp = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = temp;
        }
        return cur;
    }

    ListNode last = null;
    private ListNode reverseRecursion(ListNode head) {
        if(head.next == null) {
            last = head;
            return head;
        }
        ListNode nxt = reverseRecursion(head.next);
        ListNode cur = head;
        nxt.next = cur;
        return cur;
    }

}
