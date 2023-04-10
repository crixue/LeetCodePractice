package leetcode.list;

import leetcode.common.ListNode;

public class SwapNodesInPairs {

    private ListNode reversePairs(ListNode head) {
        if(head == null) {
            return null;
        }
        ListNode fst = head;
        for (int i = 0; i < 1; i++) {
            head = head.next;
        }
        if (head == null) {
            return fst;
        }
        ListNode nxtGrp = head.next;
        head.next = fst;
        fst.next = reversePairs(nxtGrp);

        return head;
    }

    public ListNode swapPairs(ListNode head) {
        return reversePairs(head);
    }

    public static void main(String[] args) {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode listNode = swapNodesInPairs.swapPairs(head);
        System.out.println(listNode);
    }

}
