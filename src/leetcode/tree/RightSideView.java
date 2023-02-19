package leetcode.tree;

import leetcode.tree.git.TreeNode;

import java.util.*;

public class RightSideView {


    private static LinkedList<TreeNode> treeNodes;

    private void traverse(TreeNode root) {
        if(root == null) {
            return;
        }
        if (root.left != null) {
            traverse(root.left);
        }
        treeNodes.addLast(root);
        if(root.right != null) {
            traverse(root.right);
        }
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.addLast(root);

        int level = 1;
        while (!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                TreeNode node = queue.pollFirst();
                if (res.size() < level) {
                    res.add(node.val);
                }
                if (node.right != null) {
                    queue.addLast(node.right);
                }
                if (node.left != null) {
                    queue.addLast(node.left);
                }
            }
            level++;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode l2a1 = new TreeNode(5);
        TreeNode l2a2 = new TreeNode(4);

        TreeNode l1a1 = new TreeNode(2, null, l2a1);
        TreeNode l1a2 = new TreeNode(3, null, l2a2);

        TreeNode root = new TreeNode(1, l1a1, l1a2);

        RightSideView rightSideView = new RightSideView();
        List<Integer> integers = rightSideView.rightSideView(root);
        System.out.println(integers);
    }

}
