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
    public boolean isPalindrome(ListNode head) {
        if(head.next==null) return true;
        if(head.next.next==null) return head.val==head.next.val;
        
        ListNode slow = head;
        ListNode fast = head.next;
       
        while(fast!=null) {
            
            slow=slow.next;
            if(fast.next.next==null) {
                // slow=slow.next;
                break;
            }
            fast=fast.next.next;
            
            if(fast.next==null) {
                // slow=slow.next;
                break;
            }
        }
        
        ListNode prev = null;
        ListNode curr = slow;
        
        
        while(curr!=null) {
            ListNode next = curr.next;    
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        ListNode ff = head;
        while(ff!=prev && ff!=null) {
            if(ff.val!=prev.val) return false;
            else {
                ff = ff.next;
                prev = prev.next;
            }
        }
        
        return true;
        
    }
}