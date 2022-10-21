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
    HashMap<Integer, Integer> hm = new HashMap<>();
    
    public int[] findMode(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        helper(root);
        
        int max = 0;
        for(Integer k: hm.keySet()){
            int v = hm.get(k);
            max = Math.max(v, max);
        }
        
        for(Map.Entry<Integer,Integer> e: hm.entrySet()) {
            int val = e.getValue();
            if (val==max) {
                res.add(e.getKey());
            }
        }
        
        int[] ans = new int[res.size()];
        for(int i=0; i<res.size();i++){
            ans[i] = res.get(i);
        }
        
        return ans;
        
    }
    
    public void helper(TreeNode root) {
        if (root==null) return;
        hm.put(root.val, hm.getOrDefault(root.val,0)+1);
        
        helper(root.left);
        helper(root.right);
        return;
    }
}