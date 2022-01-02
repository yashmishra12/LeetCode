/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node front = head;
        
        while(cur!=null) {
            front = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = front;
            cur = front;
        }
        
        cur = head;
        
        while(cur!=null) {
            if(cur.random!=null) {
                cur.next.random = cur.random.next;
            }
                
            cur = cur.next.next;
        }
        
        Node dummy = new Node(-1);
        Node copy = dummy;
        
        cur  = head;
        
        while(cur!=null) {
            front = cur.next.next;
            copy.next = cur.next;
            copy = copy.next;
            
            cur.next = front;
            cur = front;
        }
        
        return dummy.next;
        
        
    }
}