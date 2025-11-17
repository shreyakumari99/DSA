/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode helper(int[] preorder, int prelo, int prehi, int[] inorder, int inlo, int inhi){
        if(prelo>prehi) return null;
        TreeNode root = new TreeNode(preorder[prelo]);
        int i = inlo; 
        while(inorder[i] != preorder[prelo]) i++;
        int leftsize = i-inlo;
        root.left = helper(preorder, prelo+1, prelo+leftsize, inorder, inlo, i-1);
        root.right = helper(preorder, prelo+leftsize+1,prehi, inorder,i+1, inhi);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        return helper(preorder, 0, n-1, inorder, 0, n-1);
    }
}