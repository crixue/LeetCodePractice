package leetcode.list;

import leetcode.common.ListNode;

public class ReverseLinkedList2 {

    private ListNode nxtNodes = null;
    private ListNode last = null;
    private ListNode reverse(ListNode head, int right) {
        if(right <= 1) {
            nxtNodes = head.next;
            last = head;
            return head;
        }
        ListNode nxt = reverse(head.next, right-1);
        head.next = nxtNodes;
        nxt.next = head;
        return head;
    }

    private ListNode nxtGroup = null;
    private ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        ListNode cur = null, nxt = head;
        for (int i = k - 1; i >= 0; i--) {
            ListNode temp = nxt.next;
            if (i == 0) {
                nxtGroup = temp;
            }
            nxt.next = cur;
            cur = nxt;
            nxt = temp;
        }
        dummy.next.next = nxtGroup;
        return cur;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode pre = dummy;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        pre.next = reverseKGroup(pre.next, right-left);
        return dummy.next;
    }

    private ListNode reverseKGroup1(ListNode head, int k) {
        ListNode reverseLast = head;
        ListNode cur = null, nxt = head;
        for (int i = 0; i < k; i++) {
            ListNode temp = nxt.next;
            if(i == k - 1) {
                nxtGroup = temp;
            }
            nxt.next = cur;
            cur = nxt;
            nxt = temp;
        }
        reverseLast.next = nxtGroup;
        return cur;
    }

    public ListNode reverseKGroupBetween(ListNode head, int k) {
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode preGroup = dummy, curGroup = dummy.next, curLast = dummy.next, headValid = curGroup;
        boolean noOtherGroup = false;
        while (curGroup != null) {
            for (int i = 0; i < k; i++) {
                if(headValid == null) {
                    noOtherGroup = true;
                    break;
                }
                headValid = headValid.next;
            }
            if (noOtherGroup) {
                break;
            }
            ListNode curFst = reverseKGroup1(curGroup, k);
            preGroup.next = curFst;

            preGroup = curLast;
            curGroup = nxtGroup;
            curLast = nxtGroup;
            headValid = curGroup;
        }

        return dummy.next;
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
        ReverseLinkedList2 reverseLinkedList2 = new ReverseLinkedList2();
        ListNode listNode = reverseLinkedList2.reverseKGroupBetween(h0, 2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

}
