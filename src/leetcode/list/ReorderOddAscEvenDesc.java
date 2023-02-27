package leetcode.list;

import leetcode.common.ListNode;

public class ReorderOddAscEvenDesc {

    private ListNode mergeTwoList(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) {
            return a;
        }

        if(a.val < b.val) {
            a.next = mergeTwoList(a.next, b);
            return a;
        } else {
            b.next = mergeTwoList(b.next, a);
            return b;
        }
    }

    private ListNode mergeTwoList1(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummy;

        while (a != null && b != null) {
            if(a.val < b.val) {
                head.next = a;
                head = a;
                a = a.next;
            } else {
                head.next = b;
                head = b;
                b = b.next;
            }
        }

        if(a == null) {
            head.next = b;
        }
        if(b == null) {
            head.next = a;
        }
        return dummy.next;
    }

    public ListNode reorderOddAscEvenDesc(ListNode head) {
        ListNode oddDummy = new ListNode(Integer.MIN_VALUE);
        ListNode oddHead = oddDummy, evenLast = null;

        ListNode nxt = head;
        while (head != null) {
            nxt = nxt.next;
            if (head.val % 2 == 1) {
                oddHead.next = head;
                head.next = null;
                oddHead = head;
            } else {
                head.next = evenLast;
                evenLast = head;
            }
            head = nxt;
        }
        return mergeTwoList1(oddDummy.next, evenLast);
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(8);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(6);
        ListNode l4 = new ListNode(5);
//        ListNode l5 = new ListNode(4);
        ListNode l6 = new ListNode(7);
//        ListNode l7 = new ListNode(2);

        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
//        l4.next = l5;
//        l5.next = l6;
//        l6.next = l7;

        l4.next = l6;


        ReorderOddAscEvenDesc reorderOddAscEvenDesc = new ReorderOddAscEvenDesc();
        ListNode listNode = reorderOddAscEvenDesc.reorderOddAscEvenDesc(l0);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
