package leetcode.list;

import leetcode.common.ListNode;

public class MergeKList {

    private ListNode mergeTwoLists(ListNode a, ListNode b) {
        if(a == null) return b;
        if(b == null) return a;
        if(a.val <= b.val) {
            a.next = mergeTwoLists(a.next, b);
            return a;
        } else {
            b.next = mergeTwoLists(a, b.next);
            return b;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        if(k == 0) return null;
        if(k == 1) return lists[0];

        ListNode mergedList = lists[0];
        for (int i = 1; i < k; i++) {
            mergedList = mergeTwoLists(mergedList, lists[i]);
        }
        return mergedList;
    }
}
