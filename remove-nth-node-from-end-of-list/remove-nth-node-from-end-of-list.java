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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        int len = 0;
        
        if(n==1 && head.next==null) return null;
        
        while(p1!=null) {
            p1 = p1.next;
            len++;
        }
        
        int counter = 0;
        
        while(counter!=len - n) {
            p2 = p2.next;
            counter++;
        }
        if(p2.next==null) {
            ListNode ff = head;
            while(ff.next.next != null) ff = ff.next;
            ff.next=null;
        }
        else {
                p2.val = p2.next.val;
                p2.next = p2.next.next;
        }
   
        
        return head;
    }
}