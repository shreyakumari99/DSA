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
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode prevprev = null;
        List<TreeNode> arr = new ArrayList<>();
        while(curr!=null){
            if(curr.left!=null){
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred = pred.right;
                }
                if(pred.right==null){
                    pred.right = curr;
                    curr = curr.left;
                }
                else{
                    pred.right = null;
                    if(prev!=null && prevprev!=null){
                        if(prev.val>curr.val && prev.val>prevprev.val) arr.add(prev);
                        if(prev.val<curr.val && prev.val<prevprev.val) arr.add(prev);
                    }
                    else if(prev!=null && prev.val>curr.val) arr.add(prev);    
                    prevprev = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }
            else{
                if(prev!=null && prevprev!=null){
                    if(prev.val>curr.val && prev.val>prevprev.val) arr.add(prev);
                    if(prev.val<curr.val && prev.val<prevprev.val) arr.add(prev);
                }
                else if(prev!=null && prev.val>curr.val) arr.add(prev);    
                prevprev = prev;
                prev = curr;
                curr = curr.right;
            }
        }
        if(prev.val<prevprev.val) arr.add(prev);
        TreeNode first = arr.get(0);
        TreeNode second = arr.get(arr.size()-1);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
}