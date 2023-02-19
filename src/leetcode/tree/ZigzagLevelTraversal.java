package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;

        Deque<TreeNode> deque = new LinkedList<>();
        deque.addLast(root);
        boolean isReverseOrder = false;

        while (!deque.isEmpty()) {
            int sz = deque.size();
            LinkedList<Integer> item = new LinkedList<>();

            for (int i = 0; i < sz; i++) {
                TreeNode node = deque.pollFirst();
                if (!isReverseOrder) {
                    item.addLast(node.val);
                } else {
                    item.addFirst(node.val);
                }
                if(node.left != null) deque.addLast(node.left);
                if(node.right != null) deque.addLast(node.right);
            }

            isReverseOrder = !isReverseOrder;
            res.add(item);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode l2a1 = new TreeNode(5);
        TreeNode l2a2 = new TreeNode(4);

        TreeNode l1a1 = new TreeNode(2, l2a2, null);
        TreeNode l1a2 = new TreeNode(3, null, l2a1);

        TreeNode root = new TreeNode(1, l1a1, l1a2);
        ZigzagLevelTraversal zigzagLevelTraversal = new ZigzagLevelTraversal();
        List<List<Integer>> lists = zigzagLevelTraversal.zigzagLevelOrder(root);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

}
