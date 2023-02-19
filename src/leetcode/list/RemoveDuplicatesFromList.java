package leetcode.list;

import leetcode.common.ListNode;

public class RemoveDuplicatesFromList {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode pre = dummy, cur = pre.next;
        while (cur != null && cur.next != null) {
            ListNode nxt = cur.next;
            if((cur != null && nxt == null) || (cur.val != nxt.val)) {
                pre = cur;
                cur = nxt;
                continue;
            }
            while (nxt != null && nxt.val == cur.val) {
                nxt = nxt.next;
            }
            if(nxt == null) {
                pre.next = null;
                break;
            }
            cur = nxt;
            pre.next = cur;
        }

        return dummy.next;
    }
}
