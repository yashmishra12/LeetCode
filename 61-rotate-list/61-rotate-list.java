/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head==null) return head;
        
        int size = 1;
        ListNode origTail = head;
        
        
        while(origTail.next!=null) {
            origTail = origTail.next;
            size++;
        }
        
        int k1 = k%size;
        
        if(k1==0) return head;
        
        int counter = size - k1;
        int temp=1;
        
        ListNode newTail = head;
        
        while(temp!=counter) {
            newTail = newTail.next;
            temp++;
        }
        
        origTail.next = head;
        head = newTail.next;
        newTail.next=null;
        return head;
        
    }
}