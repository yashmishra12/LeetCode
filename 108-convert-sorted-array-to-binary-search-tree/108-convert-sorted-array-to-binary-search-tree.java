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
    static int[] globalNums;
    
    public TreeNode sortedArrayToBST(int[] nums) {
        globalNums = nums;
        return helper(0, globalNums.length-1);
    }
    
    public static TreeNode helper(int left, int right) {
        if(left>right) return null;
        
        int mid = (left+right)/2;
        
        TreeNode root = new TreeNode(globalNums[mid]);
        root.left = helper(left, mid-1);
        root.right = helper(mid+1, right);
        return root;
    }
}