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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return solve(root,0,targetSum);
    }

    public boolean solve(TreeNode root,int currsum,int targetsum){

        if(root==null){
            return false;
        }

        currsum += root.val;

        if(root.left == null && root.right == null){
            //we have reached the end leaf and now we will check whether currsum is equal to tsrgetsum or not if it is it will return true else false
             return currsum ==  targetsum;
        }

        if(solve(root.left,currsum,targetsum)){
            return true;
        }

        if(solve(root.right,currsum,targetsum)){
            return true;
        }

        return false;

    }
}