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

// RECURSIVE Solution ---- T: O(n), S: O(n)
// class Solution {
//     public List<Integer> inorderTraversal(TreeNode root) {
//         var arr = new ArrayList<Integer>();
        
//         helper(root, arr);
        
//         return arr;
        
//     }
    
//     public static void helper(TreeNode root, ArrayList<Integer> arr) {
//         if (root==null) return;
//         helper(root.left, arr);
//         arr.add(root.val);
//         helper(root.right, arr);
//     }
// }

// Iterative Solution --- T: O(n), S: O(1)
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        var arr = new ArrayList<Integer>();
        
        helper(root, arr);
        
        return arr;
        
    }
    
    public static void helper(TreeNode cur, ArrayList<Integer> arr) {
        TreeNode pre = null;
        while(cur!=null) {
            if(cur.left==null) {
                arr.add(cur.val);
                cur = cur.right;
            } else {
                pre = cur.left;
                while(pre.right!= null) pre = pre.right;
                
                pre.right = cur;
                TreeNode tmp = cur;
                cur = cur.left;
                tmp.left = null;
            }
        }
     
    }
}