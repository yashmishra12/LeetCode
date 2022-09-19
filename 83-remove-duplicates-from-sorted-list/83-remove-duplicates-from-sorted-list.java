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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        ListNode next;
        
        while(curr != null) {
            next = curr.next;
            while(next!=null && next.val==curr.val) {
                next = next.next;
            }
            curr.next = next;
            curr = next;
        }
        
        return head;
    }
}