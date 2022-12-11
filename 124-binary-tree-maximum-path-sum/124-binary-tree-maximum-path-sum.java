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
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        gainFromSubtree(root);
        return maxSum;
    }

    private int maxSum;

    private int gainFromSubtree(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = Math.max(gainFromSubtree(root.left), 0);
        int right = Math.max(gainFromSubtree(root.right), 0);
        maxSum = Math.max(maxSum, left + right + root.val);


        return Math.max(left + root.val, right + root.val);
    }
}
