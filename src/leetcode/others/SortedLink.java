package leetcode.others;


 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class SortedLink {
    private static ListNode sortAndMerge(ListNode ap, ListNode bp) {
        ListNode dummy1 = new ListNode(Integer.MIN_VALUE);
        dummy1.next = ap;
        ListNode dummy2 = new ListNode(Integer.MIN_VALUE);
        dummy2.next = bp;
        while(ap != null && bp != null) {
            if(ap.val < bp.val) {
                ap = ap.next;
            } else {
                if(bp.next == null || bp.next.val > ap.val) {
                    int temp = ap.val;
                    ap.val = bp.val;
                    bp.val = temp;
                    ap = ap.next;
                }
                bp = bp.next;
            }
        }
        ListNode a = dummy1.next;
        while(a.next != null) {
            a = a.next;
        }
        a.next = dummy2.next;
        return dummy1.next;
    }

    private static ListNode split(ListNode head, int mid) {
        //base case
        if(head.next == null) {
            return head;
        }
        ListNode fst = new ListNode(Integer.MIN_VALUE);
        fst.next = head;

        int count = 1;
        while(count < mid) {
            count++;
            head = head.next;
        }
        ListNode sec = head.next;
        head.next = null;
        return sortAndMerge(split(fst.next, mid/2),split(sec, mid/2));
    }


    public static ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;
        int count = 0;
        while(head != null) {
            count++;
            head = head.next;
        }
        return split(dummy.next, count/2);
    }

    public static void main(String[] args) {
        ListNode a1 = new ListNode(-1);
        ListNode a2 = new ListNode(5);
        ListNode a3 = new ListNode(3);
        ListNode a4 = new ListNode(4);
        ListNode a5 = new ListNode(0);
        a1.next = a2;
        a2.next = a3;
        a3.next = a4;
        a4.next = a5;

        ListNode listNode = sortList(a1);
        System.out.println(listNode);

    }

}
