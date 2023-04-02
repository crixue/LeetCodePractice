package leetcode.tree;

import leetcode.common.Node;

public class ConvertBinarySearchTreeToSortedDoublyLinkedList {

    private Node inorderTraverse(Node root, Node pre) {
        if (root == null) {
            return pre;
        }

        pre = inorderTraverse(root.left, pre);
        pre.right = root;
        root.left = pre;
        pre = root;
        pre = inorderTraverse(root.right, pre);
        return pre;
    }

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return null;
        }
        Node dummy = new Node();
        Node pre = dummy;
        pre = inorderTraverse(root, pre);
        Node fst = dummy.right;
        fst.left = pre;
        pre.right = fst;

        return dummy.right;
    }

    public static void main(String[] args) {
        ConvertBinarySearchTreeToSortedDoublyLinkedList convertBinarySearchTreeToSortedDoublyLinkedList = new ConvertBinarySearchTreeToSortedDoublyLinkedList();
        Node root = new Node(4);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        Node node = convertBinarySearchTreeToSortedDoublyLinkedList.treeToDoublyList(root);
        System.out.println(node);
    }

}
