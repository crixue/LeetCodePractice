package leetcode.list;

import leetcode.common.ListNode;

public class ReorderList {

    private ListNode reorderList(ListNode head, ListNode tail, int count, boolean order) {
        if(count == 1) {
            if(order) {
                head.next = null;
                return head;
            } else {
                tail.next = null;
                return tail;
            }
        }

        if(order) {
            head.next = reorderList(head.next, tail, count-1, !order);
            return head;
        } else {
            tail.next = reorderList(head, tail.next, count-1, !order);
            return tail;
        }
    }

    public void reorderList1(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE), reverse = new ListNode(head.val), reverseDummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        reverseDummy.next = reverse;
        int count = 1;
        while (head != null) {
            head = head.next;
            if (head != null) {
                reverse.next = new ListNode(head.val);
                reverse = reverse.next;
                count++;
            }
        }
        ListNode pre = null, cur = reverseDummy.next;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        reorderList(dummy.next, pre, count, true);
        head = dummy.next;
        System.out.println();
    }

    public void reorderList(ListNode head) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        while (head.next != slow) {
            head = head.next;
        }
        head.next = null;

        ListNode pre = null, cur = slow;
        while (cur != null) {
            ListNode nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }

        head = dummy.next;
        ListNode reorderNode = dummy;
        while(head != null && pre != null) {
            reorderNode.next = head;
            reorderNode = reorderNode.next;
            head = head.next;
            reorderNode.next = pre;
            reorderNode = reorderNode.next;
            pre = pre.next;
        }
        if (head != null) {
            reorderNode.next = head;
        }
        if (pre != null) {
            reorderNode.next = pre;
        }

        head = dummy.next;
    }

    public static void main(String[] args) {
        ListNode h0 = new ListNode(1);
        ListNode h1 = new ListNode(2);
        ListNode h2 = new ListNode(3);
        ListNode h3 = new ListNode(4);
        ListNode h4 = new ListNode(5);
        h0.next = h1;
        h1.next = h2;
        h2.next = h3;
        h3.next = h4;
        ReorderList reorderList = new ReorderList();
        reorderList.reorderList(h0);
        reorderList.reorderList(h0);
    }

}
