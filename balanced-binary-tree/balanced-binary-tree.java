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
    
    static class TreeInfo{
         boolean isBalanced;
         int height;
        
         TreeInfo(boolean isBalanced,int height) {
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }
    
    public boolean isBalanced(TreeNode root) {
        
        return helper(root).isBalanced;
        
    }
    
    public static TreeInfo helper(TreeNode node) {
        if (node==null) return new TreeInfo(true, 0);
        
        TreeInfo left = helper(node.left);
        TreeInfo right = helper(node.right);
        
        boolean cond1 = left.isBalanced;
        boolean cond2 = right.isBalanced;
        
        boolean cond3 = Math.abs(left.height-right.height)<= 1;
        
        boolean finalCond = cond1 && cond2 && cond3;
        
        int selfHeight = Math.max(left.height, right.height)+1;
        
        return new TreeInfo(finalCond, selfHeight);
    }
}