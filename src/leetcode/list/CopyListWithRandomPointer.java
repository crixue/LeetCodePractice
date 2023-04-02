package leetcode.list;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CopyListWithRandomPointer {

    public Node copyRandomList(Node head) {
        Node dummy = new Node(Integer.MIN_VALUE);
        dummy.next = head;

        Map<Node, Integer> originContainer = new HashMap<>();
        Map<Integer, Node> copyContainer = new HashMap<>();
        Node pre = null;
        for(int i=0 ; head != null; i++) {
            Node node = new Node(head.val);
            if (pre != null) {
                pre.next = node;
            }
            pre = node;

            originContainer.put(head, i);
            copyContainer.put(i, node);
            head = head.next;
        }

        head = dummy.next;
        for(int i=0 ; head != null; i++) {
            Node node = copyContainer.get(i);
            if (head.random == null) {
                head = head.next;
                continue;
            }
            Integer index = originContainer.get(head.random);
            node.random = copyContainer.get(index);
            head = head.next;
        }

        return copyContainer.get(0);
    }

    public static void main(String[] args) {
        Node n1 = new Node(3);
        Node n2 = new Node(3);
        Node n3 = new Node(3);
        n1.next = n2;
        n2.next = n3;

        n2.random = n1;
        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();
        Node node = copyListWithRandomPointer.copyRandomList(n1);
        System.out.println(node);
    }

}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}