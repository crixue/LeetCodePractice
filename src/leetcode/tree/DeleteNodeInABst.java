package leetcode.tree;

import leetcode.tree.git.TreeNode;

public class DeleteNodeInABst {

    private Integer smallestVal = null;
    private TreeNode findAndReplaceNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if(root.val < key) {
            root.right = findAndReplaceNode(root.right, key);
        } else if(root.val > key) {
            root.left = findAndReplaceNode(root.left, key);
        } else {
            //find the root.val == key
            if (root.right == null) {
                return root.left;
            }
            root.right = findAndDelTheSmallestNode(root.right);
            if (smallestVal == null) {
                return null;
            }
            root.val = smallestVal;
            return root;
        }

        return root;
    }

    private TreeNode findAndDelTheSmallestNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left != null) {
            root.left = findAndDelTheSmallestNode(root.left);
            return root;
        }
        smallestVal = root.val;
        return root.right;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        return findAndReplaceNode(root, key);
    }

    public static void main(String[] args) {
        DeleteNodeInABst deleteNodeInABst = new DeleteNodeInABst();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode node = deleteNodeInABst.deleteNode(root, 3);
        System.out.println(node);
    }

}
