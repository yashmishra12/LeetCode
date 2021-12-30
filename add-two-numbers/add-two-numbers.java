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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        int sum = 0;
        int carry = 0;
        
        while(l1!=null || l2!=null) {
            int l1_val = l1==null ? 0 : l1.val;
            int l2_val = l2==null ? 0 : l2.val;
            
            int value = l1_val + l2_val + carry;
            sum = value%10;
            carry = value/10;
            
            curr.next = new ListNode(sum);
            curr = curr.next;
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
        }
        
        if(carry!=0) {
            curr.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}