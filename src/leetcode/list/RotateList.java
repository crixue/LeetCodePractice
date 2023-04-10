package leetcode.list;

import leetcode.common.ListNode;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        ListNode countHead = head;
        int count = 0;
        for (; countHead != null; count++) {
            countHead = countHead.next;
        }
        if (count == 0) {
            return head;
        }
        k %= count;
        if (k == 0) {
            return head;
        }

        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newFstNode = slow.next;
        slow.next = null;
        fast.next = head;
        return newFstNode;
    }

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        ListNode newHead = rotateList.rotateRight(head, 6);
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
