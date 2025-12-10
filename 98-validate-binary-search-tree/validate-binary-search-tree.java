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
    static boolean flag = true;
    static TreeNode prev = null;
    public void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        if(prev==null) prev = root;
        else if(root.val<=prev.val){
            flag=false;
        }
        else prev = root;
        inorder(root.right);
    }
    public boolean isValidBST(TreeNode root) {
        flag = true;
        prev = null;
        inorder(root);
        return flag;
    }
}