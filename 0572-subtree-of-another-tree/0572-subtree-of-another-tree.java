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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null){
            return false;
        }

        if (identical(root,subRoot)){
        return true;
        }

        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    public boolean identical(TreeNode root, TreeNode subroot){
           
           if(root==null && subroot == null){
            return true;
           }

           if(root == null || subroot == null){
            return false;
           }
           
           if(root.val != subroot.val){
            return false;
           }

           return identical(root.left,subroot.left) && identical(root.right,subroot.right);
           
    }
}
