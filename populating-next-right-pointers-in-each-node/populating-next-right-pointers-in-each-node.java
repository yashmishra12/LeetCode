/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
       helper(root, null, false); 
        return root;
    }
    
    public static void helper(Node root, Node parent, boolean isLeftChild) {
        if(root==null) return;
        Node left = root.left;
        Node right = root.right;
        
        helper(left, root, true);
        
        if(parent==null) root.next = null; //for root node
        else if(isLeftChild) { 
            root.next = parent.right;
        }
        else {
            if(parent.next==null) root.next=null;
            else {
                root.next = parent.next.left;
            }
        }
        
        helper(right, root, false);
    }
    
    
}