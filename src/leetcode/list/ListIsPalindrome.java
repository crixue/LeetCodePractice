package leetcode.list;

import leetcode.common.ListNode;

public class ListIsPalindrome {

    ListNode frontHead;

    private boolean recursion(ListNode listNode) {
        if(listNode == null) {
            return true;
        }
        boolean lastRes = recursion(listNode.next);
        int curVal = listNode.val;
        int frontval = frontHead.val;
        frontHead = frontHead.next;
        return lastRes && curVal == frontval;
    }


    public boolean isPalindrome(ListNode head) {
        frontHead = head;
        return recursion(head);
    }

    public static void main(String[] args) {
        ListNode l0 = new ListNode(1);
        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(4);
        ListNode l4 = new ListNode(1);
        l0.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;

        ListIsPalindrome listIsPalindrome = new ListIsPalindrome();
        listIsPalindrome.isPalindrome(l0);
        System.out.println(listIsPalindrome);
    }
}
