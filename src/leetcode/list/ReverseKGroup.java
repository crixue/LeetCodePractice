package leetcode.list;

import leetcode.common.ListNode;

public class ReverseKGroup {

    private ListNode reverseKGroupRecursion(ListNode head, int k) {
        if(head == null) {
            return null;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode fast = head;
        int count = k - 1;
        while (fast != null && count > 0) {
            fast = fast.next;
            count--;
        }

        if(count >= 0 && fast == null) {
            return dummy.next;
        }

        ListNode nxtNodeGroup = reverseKGroupRecursion(fast.next, k);
        fast.next = null;

        ListNode cur = null, nxt = dummy.next;
        while (nxt != null) {
            ListNode tmp = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = tmp;
        }

        dummy.next.next = nxtNodeGroup;
        return cur;
    }

    private ListNode reverseList(ListNode head) {
        ListNode cur = null, nxt = head;
        while(nxt != null) {
            ListNode temp = nxt.next;
            nxt.next = cur;
            cur = nxt;
            nxt = temp;
        }
        return cur;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode pre = dummy, cur = pre.next, nxt = null;
        while (cur != null) {
            for (int i = 1; i < k && cur != null; i++) {
                cur = cur.next;
            }
            if(cur == null) {
                break;
            }
            nxt = cur.next;
            cur.next = null;

            pre.next = reverseList(pre.next);
            while (pre.next != null) {
                pre = pre.next;
            }
            cur = nxt;
            pre.next = cur;
            nxt = null;
        }

        return dummy.next;
    }
}
