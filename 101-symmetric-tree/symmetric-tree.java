class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return ((p.val == q.val)
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right));
    }

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode l = root.left;
        TreeNode r = root.right;
        root.left = invertTree(r);
        root.right = invertTree(l);
        return root;
    }
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        root.left = invertTree(root.left);
        return isSameTree(root.left,root.right);
    }
}