package leetcode.tree.git;

public class LowestCommonAncestor {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode tl = lowestCommonAncestor(root.left, p, q);
        TreeNode tr = lowestCommonAncestor(root.right, p, q);

        if(tl != null && tr != null) {
            return root;
        }
        if(tl != null) {
            return tl;
        }
        if(tr != null) {
            return tr;
        }
        return null;
    }

    public static void main(String[] args) {
        TreeNode l4a1 = new TreeNode(7);
        TreeNode l4a2 = new TreeNode(4);

        TreeNode l3a1 = new TreeNode(2, l4a1, l4a2);
        TreeNode l3a2 = new TreeNode(6);

        TreeNode l2a1 = new TreeNode(5, l3a1, l3a2);
        TreeNode l2a2 = new TreeNode(1);

        TreeNode l1a1 = new TreeNode(3, l2a1, l2a2);
        TreeNode l1a2 = new TreeNode(30);

        TreeNode root = new TreeNode(10, l1a1, l1a2);

        TreeNode result = lowestCommonAncestor(root, l4a2, l3a1);
        System.out.println(result.toString());
    }
}
